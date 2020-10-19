package model;

import userInterface.User;

import java.util.List;

public class Order {

    private List<Drug> orderedDrugs;
    private User user;

    public Order(List<Drug> orderedDrugs, User user) {
        this.orderedDrugs = orderedDrugs;
        this.user = user;
    }

    public List<Drug> getOrderedDrugs() {
        return orderedDrugs;
    }

    public void setOrderedDrugs(List<Drug> orderedDrugs) {
        this.orderedDrugs = orderedDrugs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
