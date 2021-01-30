package com.igeek.shop.pojo;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/29 19:17
 * @description： 订单项实体类
 * @version: 1.0
 */
public class OrderItem {

    private String itemid;
    //购买的数量
    private Integer count;
    //小计
    private double subtotal;
    //购买的商品
    private Product product;
    //所属的订单
    private Order order;


    public OrderItem() {
    }

    public OrderItem(String itemid, Integer count, double subtotal, Product product, Order order) {
        this.itemid = itemid;
        this.count = count;
        this.subtotal = subtotal;
        this.product = product;
        this.order = order;
    }

    /**
     * 获取
     * @return itemid
     */
    public String getItemid() {
        return itemid;
    }

    /**
     * 设置
     * @param itemid
     */
    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    /**
     * 获取
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取
     * @return subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * 设置
     * @param subtotal
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * 获取
     * @return product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * 设置
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * 获取
     * @return order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * 设置
     * @param order
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    public String toString() {
        return "OrderItem{itemid = " + itemid + ", count = " + count + ", subtotal = " + subtotal + ", product = " + product + ", order = " + order + "}";
    }
}
