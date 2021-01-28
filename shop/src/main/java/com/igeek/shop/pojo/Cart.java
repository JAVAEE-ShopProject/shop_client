package com.igeek.shop.pojo;

import java.util.List;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/28 16:24
 * @description：
 * @version: 1.0
 */
public class Cart {

    //购物车编号
    private String cartId;
    //用户信息
    private User user;
    //购物车商品项集合
    private List<CartItem> items;


    public Cart() {
    }

    public Cart(String cartId, User user, List<CartItem> items) {
        this.cartId = cartId;
        this.user = user;
        this.items = items;
    }

    /**
     * 获取
     * @return cartId
     */
    public String getCartId() {
        return cartId;
    }

    /**
     * 设置
     * @param cartId
     */
    public void setCartId(String cartId) {
        this.cartId = cartId;
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
     * @return items
     */
    public List<CartItem> getItems() {
        return items;
    }

    /**
     * 设置
     * @param items
     */
    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public String toString() {
        return "Cart{cartId = " + cartId + ", user = " + user + ", items = " + items + "}";
    }
}
