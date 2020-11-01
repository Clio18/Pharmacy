package source;

import model.DosageForm;
import model.Drug;

import java.util.ArrayList;
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
