package userInterface;

import model.Drug;

import java.util.List;

public class Bucket {
    private List<Drug> drugs;

    public Bucket(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
}
