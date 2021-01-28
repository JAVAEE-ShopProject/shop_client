package com.igeek.shop.dao.impl;

import com.igeek.shop.dao.BaseDao;
import com.igeek.shop.dao.CartDao;
import com.igeek.shop.pojo.Cart;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/28 17:04
 * @description：
 * @version: 1.0
 */
public class CartDaoImpl extends BaseDao<Cart> implements CartDao {
    @Override
    public int createCart(String cartId, String uid) {
        String sql = "insert into cart values(?,?)";
        return update(sql,cartId,uid);
    }

    @Override
    public Cart queryCartByUid(String uid) {
        String sql = "select * from cart where userId = ?";
        return queryOne(sql,Cart.class,uid);
    }
}
