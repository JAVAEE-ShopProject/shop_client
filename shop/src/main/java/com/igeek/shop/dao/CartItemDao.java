package com.igeek.shop.dao;

import com.igeek.shop.pojo.Cart;
import com.igeek.shop.pojo.CartItem;

import java.util.List;
import java.util.Map;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/28 16:50
 * @description： 购物车商品的数据库访问接口
 * @version: 1.0
 */
public interface CartItemDao {

    /**
     * 将商品添加到购物车中
     * @param pid 商品编号
     * @count 商品个数
     * @return 返回影响的行数
     */
    int addItemToCart(String cartId, Integer pid,Integer count);

    /**
     *更新购物车中指定商品的数量
     * @param cartId 购物车商品编号
     * @param pid 商品编号
     * @param count  要更新的数量
     * @return  返回影响的行数
     */
    int updateItemCountByCartIdAndPid(String cartId, Integer pid,Integer count);

    /**
     * 从购物车中 删除商品
     * @param pid 商品编号
     * @param cartId 购物车编号
     * @return 返回影响的行数
     */
    int deleteItemFromCart(String cartId, Integer pid);

    /**
     * 从购物车中查询 购物车商品项目
     * @param cartId  购物车编号
     * @return 购物车商品项集合
     */
      List<Map<String,Object>>   queryCartItemsMapListFromCart(String cartId);

      Map<String,Object> queryCartItemByCartIdAndPid(String cartId, Integer pid);

}
