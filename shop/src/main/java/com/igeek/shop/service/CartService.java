package com.igeek.shop.service;

import com.igeek.shop.pojo.Cart;
import com.igeek.shop.pojo.CartItem;

import java.util.List;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/28 18:25
 * @description： 处理购物车的业务逻辑
 * @version: 1.0
 */
public interface CartService {

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


    /**
     * 将商品添加到购物车中
     * @param pid 商品编号
     * @count 商品个数
     * @return 返回影响的行数
     */
    int addItemToCart(String cartId, String pid,Integer count);

    /**
     *更新购物车中指定商品的数量
     * @param cartId 购物车商品编号
     * @param pid 商品编号
     * @param count  要更新的数量
     * @return  返回影响的行数
     */
    int updateItemCountByCartIdAndPid(String cartId, String pid,Integer count);

    /**
     * 从购物车中 删除商品
     * @param pid 商品编号
     * @param cartId 购物车编号
     * @return 返回影响的行数
     */
    int deleteItemFromCart(String cartId, String pid);

    /**
     * 从购物车中查询 购物车商品项目
     * @param cartId  购物车编号
     * @return 购物车商品项集合 没有商品返回null
     */
    List<CartItem> queryCartItemsFromCart(String cartId);

    /**
     *
     * @param cartId 购物车编号
     * @param pid 商品编号
     * @return cartItem对象  未查到 返回null
     */
    CartItem queryCartItemByCartIdAndPid(String cartId,String pid);

    /**
     * 清空购物车
     * @param cartId 购物车编号
     * @return
     */
    int clearCart(String cartId);


}
