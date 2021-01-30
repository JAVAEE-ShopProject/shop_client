package com.igeek.shop.dao;

import com.igeek.shop.pojo.Order;
import com.igeek.shop.pojo.OrderItem;

import java.util.List;
import java.util.Map;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/29 19:26
 * @description：
 * @version: 1.0
 */
public interface OrderDao {

    /**
     * 创建订单
     * @param order 订单
     * @return 返回影响的行数
     */
    int createOrder(Order order);

    /**
     * 添加订单商品项
     * @param item 订单商品项
     * @return 返回影响的行数
     */
    int addOrderItem(OrderItem item);

    /**
     *
     * @param oid 通过订单编号查询订单商品项的信息
     * @return 返回订单中的相关信息
     */
    List<Map<String,Object>> queryOrderItemsMapListByOid(String oid);

    /**
     * 查询订单的信息 通过用户编号
     * @param uid 用户编号
     * @return 订单集合
     */
    List<Order> queryOrderByUid(String uid);

    /**
     * 通过用户编号 和订单编号 查询 指定订单
     * @param uid 用户编号
     * @param oid 订单编号
     * @return Order对象 或null(没查到)
     */
    Order queryOrderByUidAndOid(String uid,String oid);


    /**
     * 更新订单的联系人信息
     * @param o 订单
     * @return 影响的行数
     */
    int updateOrder(Order o);
}