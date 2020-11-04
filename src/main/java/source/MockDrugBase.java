package source;
import model.Drug;
import java.util.List;

public class MockDrugBase {
    private List<Drug> pharmacy;

    public MockDrugBase(List<Drug> pharmacy) {
        this.pharmacy = pharmacy;
    }

    public List<Drug> getPharmacy() {
       return pharmacy;
    }

}
