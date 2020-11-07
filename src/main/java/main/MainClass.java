package main;

import model.DosageForm;
import model.Drug;
import model.Order;
import userInterface.Bucket;
import userInterface.User;

public class MainClass {
    public static void main(String[] args) {
        Pharmacy pharmacy = new Pharmacy();
        Drug drug = new Drug("A", "AA", 1.1, true, DosageForm.HARD_CAPSULE, "AAA");
        pharmacy.addDrugToBase(drug);

        Drug foundDrug = pharmacy.findDrugById(1);
        pharmacy.addDrugToBucket(foundDrug);
        Bucket bucket = pharmacy.getBucket();
        System.out.println(bucket);

        User user = new User("A", "AA", "AAA", "AAAA", "@mail", "street", "044");
        pharmacy.addUser(user);

        User foundUser = pharmacy.findUserById(1);
        Order order = pharmacy.createOrder(foundUser);
        System.out.println(order);

    }
}
