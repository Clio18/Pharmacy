package model;

import java.util.Objects;

public class User implements Cloneable {
    private String name;
    private String familyName;
    private String login;
    private String password;
    private String email;
    private String address;
    private String phoneNumber;
    private int id;

//    public User(String name, String familyName, String login, String password, String email, String address, String phoneNumber) {
//        this.name = name;
//        this.familyName = familyName;
//        this.login = login;
//        this.password = password;
//        this.email = email;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//    }
//
//    public User() {
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class Builder{
        User user;
        public Builder(){
            user = new User();
        }
        public Builder withName(String name){
            user.name=name;
            return this;
        }
        public Builder withFamilyName(String familyName){
            user.familyName=familyName;
            return this;
        }
        public Builder withPassword(String password){
            user.password=password;
            return this;
        }
        public Builder withLogin(String login){
            user.login=login;
            return this;
        }
        public Builder withEmail(String email){
            user.email=email;
            return this;
        }
        public Builder withAddress(String address){
            user.address=address;
            return this;
        }
        public Builder withPhoneNumber(String phoneNumber){
            user.phoneNumber=phoneNumber;
            return this;
        }
        public Builder withId(Integer id){
            user.id=id;
            return this;
        }
        public User build(){
            return user;
        }

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Family Name: " + familyName +
                ", Login: " + login +
                ", Password: " + password +
                ", Email: " + email +
                ", Address: " + address +
                ", Phone Number: " + phoneNumber +
                ", id: " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getFamilyName(), user.getFamilyName()) &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getAddress(), user.getAddress()) &&
                Objects.equals(getPhoneNumber(), user.getPhoneNumber());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getFamilyName(), getLogin(), getPassword(), getEmail(), getAddress(), getPhoneNumber(), getId());
    }
}
