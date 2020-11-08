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
        Drug drug1 = new Drug("Ab", "AAb", 9.1, true, DosageForm.HARD_CAPSULE, "AAAb");
        pharmacy.createDrug(drug);
        pharmacy.createDrug(drug1);

        Drug foundDrug = pharmacy.findDrugById(1);
        Drug foundDrug1 = pharmacy.findDrugById(2);

        pharmacy.addDrugToBucket(foundDrug);
        pharmacy.addDrugToBucket(foundDrug1);

        Bucket bucket = pharmacy.getBucket();
        System.out.println(bucket);

        User user = new User("A", "AA", "AAA", "AAAA", "@mail", "street", "044");
        pharmacy.addUser(user);

        User foundUser = pharmacy.findUserByLoginAndPassword("AAA", "AAAA");
        Order order = pharmacy.createOrder(foundUser);
        System.out.println(order);
    }
}
