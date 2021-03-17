package main;

import model.DosageForm;
import model.Drug;
import model.Order;
import userInterface.Bucket;
import userInterface.User;

public class MainClass {
    public static void main(String[] args) {
        Pharmacy pharmacy = new Pharmacy();
        Drug drug = new Drug.Builder()
        .withDescription("Aab")
        .withName("Aa")
        .withPrice(14.99)
        .withDosageForm(DosageForm.HARD_CAPSULE)
        .withManufacturer("Aaaa")
        .withAvailable(false)
        .build();

        Drug drug1 = new Drug.Builder()
                .withDescription("Ccc")
                .withName("Ccccc")
                .withPrice(100.99)
                .withDosageForm(DosageForm.SOFT_CAPSULE)
                .withManufacturer("Aaaad")
                .withAvailable(true)
                .build();
        pharmacy.createDrug(drug);
        pharmacy.createDrug(drug1);

        Drug foundDrug = pharmacy.findDrugById(1);
        Drug foundDrug1 = pharmacy.findDrugById(2);

        pharmacy.addDrugToBucket(foundDrug);
        pharmacy.addDrugToBucket(foundDrug1);

        Bucket bucket = pharmacy.getBucket();
        System.out.println(bucket);

        User user = new User.Builder()
                .withLogin("A")
                .withPassword("AA")
                .withName("AAA")
                .withFamilyName("AAAAA")
                .withEmail("@mail")
                .withAddress("street")
                .withPhoneNumber("044")
                .build();
        pharmacy.addUser(user);

        User foundUser = pharmacy.findUserByLoginAndPassword("AAA", "AAAA");
        Order order = pharmacy.createOrder(foundUser);
        System.out.println(order);
    }
}
