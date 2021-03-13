package validation;
import userInterface.User;

import java.util.ArrayList;
import java.util.List;

public class UserValidator implements ValidatorForApp<User> {
   public List<Alerts> alertsList = new ArrayList<>();


    public List<Alerts> validate(User user) {
        try {
            nameCheck(user);
            familyNameCheck(user);
            emailCheck(user);
            phoneCheck(user);
        }catch (NullPointerException e){
         alertsList.add(Alerts.WRONG_USER);
        }
        return alertsList;
    }

    public void nameCheck(User user) {
        if (!user.getName().matches("^([A-Z]{1}[a-z]{1,23})$")) {
            alertsList.add(Alerts.WRONG_NAME);
        }
    }

    public void familyNameCheck(User user) {
        if (!user.getFamilyName().matches("^([A-Z]{1}[a-z]{1,23})$")) {
            alertsList.add(Alerts.WRONG_FAMILY_NAME);
        }
    }

    public void emailCheck(User user) {
        if (!user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            alertsList.add(Alerts.WRONG_EMAIL);
        }
    }

    public void phoneCheck(User user) {
        if (!user.getPhoneNumber().matches("^\\+?3?8?(0[5-9][0-9]\\d{7})$")) {
            alertsList.add(Alerts.WRONG_PHONE_NUMBER);
        }
    }

//    public void showAlerts() {
//        if (alertsList.isEmpty()) {
//            System.out.println(validator.Alerts.GOOD.getValue());
//        } else {
//            for (validator.Alerts alerts : alertsList) {
//                System.out.println(alerts.getValue());
//            }
//        }
 //   }


}
