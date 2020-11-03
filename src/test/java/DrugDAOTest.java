import dao.DrugDAO;
import exception.DrugNotFoundException;
import model.DosageForm;
import model.Drug;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DrugDAOTest {

    private DrugDAO drugDAO;

    Drug drug1 = new Drug("A", "AA", 1.1, true, DosageForm.HARD_CAPSULE, "AAA", 1);
    Drug drug2 = new Drug("B", "BB", 2.1, true, DosageForm.LINIMENT, "BBB", 2);
    Drug drug3 = new Drug("C", "CC", 3.1, true, DosageForm.HARD_CAPSULE, "CCC", 3);

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
        drugDAO = new DrugDAO(helperForGetList());
    }

    private List<Drug> helperForGetList() {
        List<Drug> drugList = new ArrayList<>();
        drugList.add(drug1);
        drugList.add(drug2);
        drugList.add(drug3);
        return drugList;
    }

    @Test
    public void whenAddNewDrug() throws Exception {
        assertThat(drugDAO.getAll().size(), is(3));
        drugDAO.save(new Drug("D", "DD", 4.1, true, DosageForm.HARD_CAPSULE, "DDD", 4));
        assertThat(drugDAO.getAll().size(), is(4));
    }

    @Test
    public void whenDeleteDrugById() {
        drugDAO = new DrugDAO(helperForGetList());

        boolean result = drugDAO.delete(100);
        assertThat(drugDAO.getAll().size(), is(3));
        assertEquals(result, false);

        boolean result1 = drugDAO.delete(1);
        assertThat(drugDAO.getAll().size(), is(2));
        assertEquals(result1, true);

    }

    @Test
    public void whenFindDrugById() {
        assertEquals(drugDAO.findById(1), drug1);
        assertEquals(drugDAO.findById(900), null);

        boolean result = drugDAO.save(new Drug("Vitamin", "Vitamin", 1.1, true, DosageForm.HARD_CAPSULE, "AAA", 1));
        assertEquals(drugDAO.findById(1), drug1);
        assertEquals(result, false);
    }


    @Test
    public void whenUpdateDrug() {
        Drug updatedDrug = new Drug("Az", "AAz", 1.1, false, DosageForm.HARD_CAPSULE, "AAAz", 1);
        drugDAO.update(updatedDrug);
        assertEquals(updatedDrug, drugDAO.findById(1));
    }

    @Test
    public void whenUpdateDrugException() {
        Drug updatedDrug = new Drug("Az", "AAz", 1.1, false, DosageForm.HARD_CAPSULE, "AAAz", 100);
        try {
            drugDAO.update(updatedDrug);
        } catch (Exception e) {
            assertEquals(e.getMessage(), new DrugNotFoundException().getMessage());
        }
    }

    @Test
    public void whenFindDrugByName() {
        assertEquals(drugDAO.findByName("AA"), drug1);
    }

    @Test
    public void whenReturnAll() {
        assertThat(drugDAO.getAll().size(), is(3));
    }

    @Test
    public void whenFindByPrice() {
        List<Drug> found = drugDAO.findDrugsByPrice(1.0, 2.0);
        assertThat(found.size(), is(1));
    }
}
