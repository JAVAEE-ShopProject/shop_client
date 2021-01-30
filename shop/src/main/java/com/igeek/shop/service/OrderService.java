package com.igeek.shop.service;

import com.igeek.shop.pojo.Order;
import com.igeek.shop.pojo.OrderItem;

import java.util.List;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/30 11:18
 * @description： 订单业务逻辑类
 * @version: 1.0
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order 订单
     * @return 返回影响的行数
     */
    int createOrder(Order order);


    /**
     *
     * @param oid 通过订单编号查询订单商品项的信息
     * @return 返回订单中的相关信息
     */
    List<OrderItem> queryOrderItemsByOid(String oid);

    /**
     * 查询订单的信息 通过用户编号
     * @param uid 用户编号
     * @return 订单集合
     */
    List<Order> queryOrderByUid(String uid);


    /**
     * 更新订单的联系人信息
     * @param o 订单
     * @return 影响的行数
     */
    int updateOrder(Order o);

    /**
     * 通过订单编号查询订单
     * @param oid 订单编号
     * @return
     */
    Order queryOrderByOid(String oid);
}
