import dao.DrugDAO;
import exception.DrugNotFoundException;
import model.DosageForm;
import model.Drug;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DrugDAOTest {

    private DrugDAO drugDAO;


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void globalSetUp() {
        System.out.println("Initial setup...");
        System.out.println("Code executes only once");

    }


    @Before
    public void setUp() {
        System.out.println("Code executes before each test method");
        drugDAO = new DrugDAO();

    }


     @Test
    public void whenReturnAll() {
        drugDAO.save(new Drug("A", "AA", 1.1, true, DosageForm.HARD_CAPSULE, "AAA"));
         assertEquals(drugDAO.getAll().size(), 1);
    }

    @Test
    public void whenFindDrugById() {
        Drug saved = drugDAO.save(new Drug("A", "AA", 1.1, true, DosageForm.HARD_CAPSULE, "AAA"));
        assertEquals(drugDAO.findById(saved.getId()).getName(), saved.getName());
        assertEquals(drugDAO.findById(-1), null);
    }

    @Test
    public void whenAddNewDrug() throws Exception {
        drugDAO.save(new Drug("A", "AA", 1.1, true, DosageForm.HARD_CAPSULE, "AAA"));
        assertEquals(drugDAO.getAll().size(), 1);
        drugDAO.save(new Drug("D", "DD", 4.1, true, DosageForm.HARD_CAPSULE, "DDD"));
        assertThat(drugDAO.getAll().size(), is(2));
    }


    @Test
    public void whenDeleteDrugById() {
        Drug saved = drugDAO.save(new Drug("A", "AA", 1.1, true, DosageForm.HARD_CAPSULE, "AAA"));
        boolean result = drugDAO.delete(saved.getId());
        assertThat(drugDAO.getAll().size(), is(0));
        assertEquals(result, true);

        boolean anotherResult = drugDAO.delete(saved.getId());
        assertEquals(anotherResult, false);
    }

    @Test
    public void whenUpdateDrug() {
        Drug saved = drugDAO.save(new Drug("A", "AA", 1.1, true, DosageForm.HARD_CAPSULE, "AAA"));
        Drug saved2 = drugDAO.save(new Drug("Ann", "AAnnn", 1.1, true, DosageForm.HARD_CAPSULE, "AAA"));
        Drug drugForUpdate = drugDAO.findByName(saved.getName());
        drugForUpdate.setName("Ola");
        drugDAO.update(drugForUpdate);
        assertEquals(drugDAO.findById(saved.getId()).getName(), drugForUpdate.getName());
        assertFalse(drugDAO.findById(saved.getId()).getName().equals(saved2.getName()));
        drugDAO.update(saved2);
        assertEquals(drugDAO.findById(saved2.getId()).getName(), saved2.getName());

    }

    @Test
    public void whenUpdateDrugException() {
        Drug updatedDrug = new Drug("Az", "AAz", 1.1, false, DosageForm.HARD_CAPSULE, "AAAz");
        try {
            drugDAO.update(updatedDrug);
        } catch (Exception e) {
            assertEquals(e.getMessage(), new DrugNotFoundException().getMessage());
        }
    }

    @Test
    public void whenFindDrugByName() {
        Drug saved = drugDAO.save(new Drug("A", "AA", 1.1, true, DosageForm.HARD_CAPSULE, "AAA"));
        assertEquals(drugDAO.findByName(saved.getName()).getDescription(), saved.getDescription());
    }



    @Test
    public void whenFindByPrice() {
        Drug saved = drugDAO.save(new Drug("A", "AA", 1.1, true, DosageForm.HARD_CAPSULE, "AAA"));
        Drug saved2 = drugDAO.save(new Drug("Ann", "AAnnn", 1.5, true, DosageForm.HARD_CAPSULE, "AAA"));
        List<Drug> found = drugDAO.findDrugsByPrice(1.0, 2.0);
        assertThat(found.size(), is(2));
    }
}
