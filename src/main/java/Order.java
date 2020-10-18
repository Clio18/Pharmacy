import java.util.List;

public class Order {

    private List<Drug> order_drug;
    private String customer_data;
    private String email;
    private String address;
    private String phone_number;

    public Order(List<Drug> order_drug, String customer_data, String email, String address, String phone_number) {
        this.order_drug = order_drug;
        this.customer_data = customer_data;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
    }

    public List<Drug> getOrder_drug() {
        return order_drug;
    }

    public void setOrder_drug(List<Drug> order_drug) {
        this.order_drug = order_drug;
    }

    public String getCustomer_data() {
        return customer_data;
    }

    public void setCustomer_data(String customer_data) {
        this.customer_data = customer_data;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
