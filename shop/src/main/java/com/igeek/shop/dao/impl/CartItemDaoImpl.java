package com.igeek.shop.dao.impl;

import com.igeek.shop.dao.BaseDao;
import com.igeek.shop.dao.CartItemDao;
import com.igeek.shop.pojo.Cart;
import com.igeek.shop.pojo.CartItem;

import java.util.List;
import java.util.Map;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/28 17:08
 * @description：
 * @version: 1.0
 */
public class CartItemDaoImpl extends BaseDao<CartItem> implements CartItemDao {

    @Override
    public int addItemToCart(String cartId, String pid,Integer count) {
        String sql = "insert into cartItem values(null,?,?,?)";
        return update(sql,cartId,pid,count);
    }

    @Override
    public int updateItemCountByCartIdAndPid(String cartId, String pid, Integer count) {
        String sql = "update cartItem set count = ? where cartId = ? and productId = ?";
        return update(sql,count,cartId,pid);
    }

    @Override
    public int deleteItemFromCart(String cartId, String pid) {

        String sql = "delete from cartItem where cartId = ? and productId = ?";
        return update(sql,cartId,pid);
    }

    @Override
    public List<Map<String, Object>> queryCartItemsMapListFromCart(String cartId) {
        String sql = "select * from cartitem inner join product on productId = pid where cartId = ?";
        return queryListMap(sql,cartId);
    }

    @Override
    public Map<String,Object> queryCartItemByCartIdAndPid(String cartId, String pid) {
        String sql = "select * from cartItem inner join product on productId = pid where cartId = ? and productId = ?";
        return queryMap(sql,cartId,pid);
    }

    @Override
    public int deleteAllCartItemByCartId(String cartId) {
        String sql = "delete from cartItem where cartId = ?";
        return update(sql,cartId);
    }


}
