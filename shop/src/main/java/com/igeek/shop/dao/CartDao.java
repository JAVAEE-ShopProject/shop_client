package com.igeek.shop.dao;

import com.igeek.shop.pojo.Cart;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/28 16:38
 * @description：  购物车的数据库访问接口
 * @version: 1.0
 */
public interface CartDao {

    /**
     * 创建购物车
     * @param cartId 购物车编号
     * @param uid 用户编号
     * @return 返回影响的行数
     */
    int createCart(String cartId,String uid);

    /**
     * 通过用户编号查询购物车
     * @param uid 用户编号
     * @return 购物车
     */
    Cart queryCartByUid(String uid);

}
