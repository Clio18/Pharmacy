import dao.DrugDAO;
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
        Drug drug1 = new Drug("A", "AA", 1.1, true, DosageForm.HARD_CAPSULE, "AAA", 1);
        Drug drug2 = new Drug("B", "BB", 2.1, true, DosageForm.LINIMENT, "BBB", 2);
        Drug drug3 = new Drug("C", "CC", 3.1, true, DosageForm.HARD_CAPSULE, "CCC", 3);
        List<Drug> drugList = new ArrayList<>();
        drugList.add(drug1);
        drugList.add(drug2);
        drugList.add(drug3);
        drugDAO = new DrugDAO(drugList);
    }

    @Test
    public void whenAddNewDrug() throws Exception {
        assertThat(drugDAO.getAll().size(), is(3));
        drugDAO.save(new Drug("D", "DD", 4.1, true, DosageForm.HARD_CAPSULE, "DDD", 4));
        assertThat(drugDAO.getAll().size(), is(4));
    }

    @Test
    public void whenDeleteDrugById() {
        drugDAO.delete(1);
        List<Drug> drugList = drugDAO.getAll();
        assertThat(drugList.size(), is(2));
    }

    @Test
    public void whenFindDrugById() throws CloneNotSupportedException {
        assertEquals(drugDAO.get(1), drugDAO.getAll().get(0));
    }

    @Test
    public void whenUpdateDrug() throws CloneNotSupportedException {
        Drug updatedDrug = new Drug("Az", "AAz", 1.1, false, DosageForm.HARD_CAPSULE, "AAAz", 1);
        drugDAO.update(updatedDrug);
        assertEquals(updatedDrug, drugDAO.get(1));
    }

    @Test
    public void whenFindDrugByName() throws CloneNotSupportedException {
        assertEquals(drugDAO.findByName("AA"), drugDAO.getAll().get(0));
    }

    @Test
    public void whenReturnAll() {
        assertThat(drugDAO.getAll().size(), is(3));
    }

    @Test
    public void whenFindByPrice() {
        List <Drug> finded = drugDAO.findDrugsByPrice(1.0, 2.0);
        assertThat(finded.size(), is(1));
    }
}
