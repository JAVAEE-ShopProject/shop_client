package com.igeek.shop.pojo;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/28 16:25
 * @description： 购物车商品项
 * @version: 1.0
 */
public class CartItem {

    //与之关联的购物车
    private Cart cart;

    //商品项目
    private Product product;

    //该商品加入购物车的数量
    private  Integer count;

    //购物车商品项小计
    private Double totalPrice;


    public CartItem() {
    }

    public CartItem(Cart cart, Product product, Integer count, Double totalPrice) {
        this.cart = cart;
        this.product = product;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    /**
     * 获取
     * @return cart
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * 设置
     * @param cart
     */
    public void setCart(Cart cart) {
        this.cart = cart;
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
     * @return totalPrice
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置
     * @param totalPrice
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "CartItem{cart = " + cart + ", product = " + product + ", count = " + count + ", totalPrice = " + totalPrice + "}";
    }
}
