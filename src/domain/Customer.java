package domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Integer cust_id;
    private String cust_name;
    private String cust_profession;
    private String cust_phone;
    private String email;

    private List<Order> orders = new ArrayList<>();

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_profession() {
        return cust_profession;
    }

    public void setCust_profession(String cust_profession) {
        this.cust_profession = cust_profession;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_profession='" + cust_profession + '\'' +
                ", cust_phone='" + cust_phone + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders +
                '}';
    }
}
