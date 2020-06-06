package rj.bookstore.order.entity;

import rj.bookstore.user.domain.User;

import java.util.Date;
import java.util.*;

public class Order {

    private String oid;
    private Date ordertime;
    private double total;
    private int state;          // 4 种状态
    private User owner;
    private String address;

    private List<OrderItem> orderItemList; // 当前订单下所有条目

    public Order(){}

    public Order(String oid, Date ordertime, double total, int state, User owner, String address) {
        this.oid = oid;
        this.ordertime = ordertime;
        this.total = total;
        this.state = state;
        this.owner = owner;
        this.address = address;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}

