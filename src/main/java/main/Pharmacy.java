package main;
import model.Drug;
import model.Order;
import service.DrugService;
import service.UserService;
import model.Bucket;
import model.User;

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
       bucket.getDrugs().add(drug);
    }

    public Bucket getBucket(){
        return bucket;
    }

    public Order createOrder(User user){
        return new Order(bucket, user);

    }

    public User findUserById(int id) {
        return userService.findDrugById(id);
    }

    public void createDrug(Drug drug) {
        drugService.save(drug);
    }

    public void addUser(User user) {
        userService.save(user);
    }

    public User findUserByLoginAndPassword(String login, String password) {
       return userService.findUserByLoginAndPassword(login, password);
    }
}
