package main;

import model.Drug;
import model.Order;
import service.DrugService;
import userInterface.Bucket;
import userInterface.User;

import java.util.ArrayList;
import java.util.List;

public class Pharmacy {
    public DrugService drugService;

    //medicines Count();
    public int count(){
        return drugService.getAll().size();
    }
    //
    //find Medicines for page number, and page size
    //
    //find Medicines by filter params(type, availability, country) and order(price)
    //
    //find Medicine by id
    public Drug findDrugById(int id){
        return drugService.findDrugById(id);

    }
    //
    //add medicine to cart
    public Bucket addDrugToBucket(Drug drug){
        List<Drug> drugList = new ArrayList<>();
        drugList.add(drug);
        return new Bucket(drugList);

    }
    //
    //get cart
    public Bucket getBucket(List<Drug> drugList){
        return new Bucket(drugList);

    }
    //
    //create order
    public Order createOrder(Bucket bucket, User user){
        return new Order(bucket, user);

    }

}
