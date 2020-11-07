package model;

import userInterface.Bucket;
import userInterface.User;

import java.util.List;

public class Order {

    private Bucket bucket;
    private User user;

    public Order(Bucket orderedDrugs, User user) {
        this.bucket = orderedDrugs;
        this.user = user;
    }

    public Bucket getOrderedDrugs() {
        return bucket;
    }

    public void setOrderedDrugs(Bucket orderedDrugs) {
        this.bucket = orderedDrugs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "bucket=" + bucket +
                ", user=" + user +
                '}';
    }
}
