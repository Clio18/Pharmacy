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
        drugDAO.save(new Drug.Builder()
                .withDescription("Aab")
                .withName("Aa")
                .withPrice(14.99)
                .withDosageForm(DosageForm.HARD_CAPSULE)
                .withManufacturer("Aaaa")
                .withAvailable(false)
                .build());
        drugDAO.save(new Drug.Builder()
                .withDescription("Ccc")
                .withName("Ccc")
                .withPrice(10.99)
                .withDosageForm(DosageForm.HARD_CAPSULE)
                .withManufacturer("Aaaa")
                .withAvailable(true)
                .build());
        drugDAO.save(new Drug.Builder()
                .withDescription("Aabb")
                .withName("Aann")
                .withPrice(1994.99)
                .withDosageForm(DosageForm.HARD_CAPSULE)
                .withManufacturer("NNN")
                .withAvailable(false)
                .build());
        assertEquals(drugDAO.getAll().size(), 3);
    }

    @Test
    public void whenFindDrugById() {
        Drug saved = drugDAO.save(new Drug.Builder()
                .withDescription("Aab")
                .withName("Aa")
                .withPrice(14.99)
                .withDosageForm(DosageForm.HARD_CAPSULE)
                .withManufacturer("Aaaa")
                .withAvailable(false)
                .build());
        assertEquals(drugDAO.findById(saved.getId()).getName(), saved.getName());
        assertEquals(drugDAO.findById(-1), null);
    }

    @Test
    public void whenAddNewDrug() {
        drugDAO.save(new Drug.Builder()
                .withDescription("Aab")
                .withName("Aa")
                .withPrice(14.99)
                .withDosageForm(DosageForm.HARD_CAPSULE)
                .withManufacturer("Aaaa")
                .withAvailable(false)
                .build());
        assertEquals(drugDAO.getAll().size(), 1);
        drugDAO.save(new Drug.Builder()
                .withDescription("Akkab")
                .withName("Aa")
                .withPrice(4.99)
                .withDosageForm(DosageForm.HARD_CAPSULE)
                .withManufacturer("KKK")
                .withAvailable(false)
                .build());
        assertThat(drugDAO.getAll().size(), is(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddNewDrugException() {
        Drug drug = null;
        drugDAO.save(drug);
    }


    @Test
    public void whenDeleteDrugById() {
        Drug saved = drugDAO.save(new Drug.Builder()
                .withDescription("Aab")
                .withName("Aa")
                .withPrice(14.99)
                .withDosageForm(DosageForm.HARD_CAPSULE)
                .withManufacturer("Aaaa")
                .withAvailable(false)
                .build());
        boolean result = drugDAO.delete(saved.getId());
        assertThat(drugDAO.getAll().size(), is(0));
        assertEquals(result, true);

        boolean anotherResult = drugDAO.delete(saved.getId());
        assertEquals(anotherResult, false);
    }

    @Test
    public void whenUpdateDrug() {
        Drug saved = drugDAO.save(new Drug.Builder()
                .withDescription("Aab")
                .withName("Aa")
                .withPrice(14.99)
                .withDosageForm(DosageForm.HARD_CAPSULE)
                .withManufacturer("Aaaa")
                .withAvailable(false)
                .build());
        Drug drugForUpdate = drugDAO.findByName(saved.getName());
        drugForUpdate.setName("Ola");
        drugDAO.update(drugForUpdate);
        assertEquals(drugDAO.findById(saved.getId()).getName(), drugForUpdate.getName());
    }

    @Test(expected = DrugNotFoundException.class)
    public void whenUpdateDrugException() {
        Drug updatedDrug = new Drug.Builder()
                .withDescription("Aab")
                .withName("Aa")
                .withPrice(14.99)
                .withDosageForm(DosageForm.HARD_CAPSULE)
                .withManufacturer("Aaaa")
                .withAvailable(false)
                .build();
        drugDAO.update(updatedDrug);
    }

    @Test
    public void whenFindDrugByName() {
        Drug saved = drugDAO.save(new Drug.Builder()
                .withDescription("Aab")
                .withName("Aa")
                .withPrice(14.99)
                .withDosageForm(DosageForm.HARD_CAPSULE)
                .withManufacturer("Aaaa")
                .withAvailable(false)
                .build());
        assertEquals(drugDAO.findByName(saved.getName()).getDescription(), saved.getDescription());
    }


    @Test
    public void whenFindByPrice() {
        drugDAO.save(new Drug.Builder()
                .withDescription("Aab")
                .withName("Aa")
                .withPrice(14.99)
                .withDosageForm(DosageForm.HARD_CAPSULE)
                .withManufacturer("Aaaa")
                .withAvailable(false)
                .build());
        drugDAO.save(new Drug.Builder()
                .withDescription("Aab")
                .withName("Aa")
                .withPrice(14.99)
                .withDosageForm(DosageForm.HARD_CAPSULE)
                .withManufacturer("Aaaa")
                .withAvailable(false)
                .build());
        List<Drug> found = drugDAO.findDrugsByPrice(1.0, 20.0);
        assertThat(found.size(), is(2));
    }
}
