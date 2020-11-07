package main;

import model.Drug;
import model.Order;
import service.DrugService;
import service.UserService;
import userInterface.Bucket;
import userInterface.User;

import java.util.ArrayList;
import java.util.List;

public class Pharmacy {
    private DrugService drugService = new DrugService();
    private UserService userService = new UserService();
    private Bucket bucket = new Bucket();
    private Order order;


    public int count(){
        return drugService.getAll().size();
    }

    public Drug findDrugById(int id){
        return drugService.findDrugById(id);

    }

    public void addDrugToBucket(Drug drug){
        List<Drug> drugList = new ArrayList<>();
        drugList.add(drug);
        bucket.setDrugs(drugList);
    }

    public Bucket getBucket(){
        return bucket;
    }

    public Order createOrder(User user){
        return new Order(bucket, user);

    }

    public User findUserById(int i) {
        return userService.findDrugById(i);
    }

    public void addDrugToBase(Drug drug) {
        drugService.save(drug);
    }

    public void addUser(User user) {
        userService.save(user);
    }
}
