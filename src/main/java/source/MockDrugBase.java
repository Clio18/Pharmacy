package source;

import model.DosageForm;
import model.Drug;

import java.util.ArrayList;
import java.util.List;

public class MockDrugBase {
    private List<Drug> pharmacy;

    public MockDrugBase() {
        this.pharmacy = new ArrayList<>();
        pharmacy.add(new Drug("q", "w", 10.1, true, DosageForm.HARD_CAPSULE, "r", 1));
    }

    public List<Drug> getPharmacy() {
        return pharmacy;
    }
}
