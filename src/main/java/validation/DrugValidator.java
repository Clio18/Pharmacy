package validation;
import model.Drug;

import java.util.ArrayList;
import java.util.List;

public class DrugValidator implements ValidatorForApp<Drug>{
    public List<Alerts> alertsList = new ArrayList<>();
    @Override
    public List<Alerts> validate(Drug drug) {
        try {
            drugNameCheck(drug);
        }catch (NullPointerException e){
            alertsList.add(Alerts.WRONG_DRUG);
        }
        return alertsList;
    }

    public void drugNameCheck(Drug drug) {
        if (!drug.getName().matches("^[A-Za-z0-9_-]*$")) {
            alertsList.add(Alerts.WRONG_DRUG_NAME);
        }

    }

}
