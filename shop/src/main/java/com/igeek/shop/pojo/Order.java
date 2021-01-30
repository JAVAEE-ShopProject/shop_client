package com.igeek.shop.pojo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/29 19:16
 * @description： 订单实体类
 * @version: 1.0
 */
public class Order {
    //订单编号
    private  String oid;
    //下单时间
    private Date ordertime;
    //订单总计
    private Double total;
    //订单状态
    private Integer state;
    //收件人信息
    private String address;
    private String name;
    private String telephone;
    //下单人
    private User user;
    //订单商品项
    private List<OrderItem> orderItems;


    public Order() {
    }

    public Order(String oid, Date ordertime, Double total, Integer state, String address, String name, String telephone, User user, List<OrderItem> orderItems) {
        this.oid = oid;
        this.ordertime = ordertime;
        this.total = total;
        this.state = state;
        this.address = address;
        this.name = name;
        this.telephone = telephone;
        this.user = user;
        this.orderItems = orderItems;
    }

    /**
     * 获取
     * @return oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * 设置
     * @param oid
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * 获取
     * @return ordertime
     */
    public Date getOrdertime() {
        return ordertime;
    }

    /**
     * 设置
     * @param ordertime
     */
    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    /**
     * 获取
     * @return total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * 获取
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 获取
     * @return orderItems
     */
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    /**
     * 设置
     * @param orderItems
     */
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String toString() {
        return "Order{oid = " + oid + ", ordertime = " + ordertime + ", total = " + total + ", state = " + state + ", address = " + address + ", name = " + name + ", telephone = " + telephone + ", user = " + user + ", orderItems = " + orderItems + "}";
    }
}
