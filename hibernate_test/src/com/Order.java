package com;

/**
 * Created by Andrew on 2015/12/28.
 */
public class Order {

    private String id;

    private String orderNumber;

    private String price;

    private Customer customer;

    public Order(String orderNumber,String price, Customer customer){
        this.orderNumber = orderNumber;
        this.price = price;
        this.customer = customer;

    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    private void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPrice() {
        return price;
    }

    private void setPrice(String price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    private void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
