package com.igeek.shop.service.impl;

import com.igeek.shop.dao.CartDao;
import com.igeek.shop.dao.CartItemDao;
import com.igeek.shop.dao.impl.CartDaoImpl;
import com.igeek.shop.dao.impl.CartItemDaoImpl;
import com.igeek.shop.pojo.Cart;
import com.igeek.shop.pojo.CartItem;
import com.igeek.shop.pojo.Product;
import com.igeek.shop.service.CartService;
import com.igeek.shop.utils.WebUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/28 18:31
 * @description：
 * @version: 1.0
 */
public class CartServiceImpl implements CartService {

    private CartItemDao cartItemDao = new CartItemDaoImpl();
    private CartDao cartDao = new CartDaoImpl();
    @Override
    public int createCart(String cartId, String uid) {
        //查询该用户是否有购物车 没有就创建
        Cart cart = queryCartByUid(uid);
        if(cart == null){
            return cartDao.createCart(cartId,uid);
        }
        return 0;
    }

    @Override
    public Cart queryCartByUid(String uid) {
        return cartDao.queryCartByUid(uid);
    }

    @Override
    public int addItemToCart(String cartId, Integer pid, Integer count) {
        return cartItemDao.addItemToCart(cartId,pid,count);
    }

    @Override
    public int updateItemCountByCartIdAndPid(String cartId, Integer pid, Integer count) {
        return cartItemDao.updateItemCountByCartIdAndPid(cartId, pid, count);
    }

    @Override
    public int deleteItemFromCart(String cartId, Integer pid) {
        return cartItemDao.deleteItemFromCart(cartId, pid);
    }

    @Override
    public List<CartItem> queryCartItemsFromCart(String cartId) {
        List<Map<String, Object>> list = cartItemDao.queryCartItemsMapListFromCart(cartId);
        if(list == null)
            return null;
        List<CartItem> cartItems = new ArrayList<>();
        for (Map<String, Object> map : list) {
            CartItem cartItem = WebUtils.parseMapToBean(new CartItem(), map);
            Product product = WebUtils.parseMapToBean(new Product(), map);
            cartItem.setProduct(product);
            cartItem.setTotalPrice(product.getShop_price()*cartItem.getCount());
            cartItems.add(cartItem);
        }
        return cartItems;
    }

    @Override
    public CartItem queryCartItemByCartIdAndPid(String cartId,Integer pid) {
        Map<String, Object> map = cartItemDao.queryCartItemByCartIdAndPid(cartId, pid);
        if(map == null)
            return null;
        CartItem cartItem = WebUtils.parseMapToBean(new CartItem(), map);
        Product product = WebUtils.parseMapToBean(new Product(), map);
        cartItem.setProduct(product);
        cartItem.setTotalPrice(cartItem.getCount()*product.getShop_price());
        return cartItem;
    }
}
