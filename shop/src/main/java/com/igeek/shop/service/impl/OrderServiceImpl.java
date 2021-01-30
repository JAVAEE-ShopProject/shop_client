package com.igeek.shop.service.impl;

import com.igeek.shop.dao.OrderDao;
import com.igeek.shop.dao.impl.OrderDaoImpl;
import com.igeek.shop.pojo.Order;
import com.igeek.shop.pojo.OrderItem;
import com.igeek.shop.pojo.Product;
import com.igeek.shop.pojo.User;
import com.igeek.shop.service.OrderService;
import com.igeek.shop.utils.WebUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/30 14:10
 * @description：
 * @version: 1.0
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    @Override
    public int createOrder(Order order) {
        //创建订单
       orderDao.createOrder(order);
        List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem item :orderItems){
            //添加订单项目
            orderDao.addOrderItem(item);
        }
        return 1;
    }

    @Override
    public List<OrderItem> queryOrderItemsByOid(String oid) {
        List<Map<String, Object>> list = orderDao.queryOrderItemsMapListByOid(oid);
        if(list == null)
            return null;
        List<OrderItem> orderItems = new ArrayList<>();
        for (Map<String,Object> map :list){
            Product product = WebUtils.parseMapToBean(new Product(), map);
            OrderItem orderItem = WebUtils.parseMapToBean(new OrderItem(),map);
            orderItem.setProduct(product);
            orderItem.setSubtotal(product.getShop_price()*orderItem.getCount());
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    @Override
    public List<Order> queryOrderByUid(String uid) {

        return  orderDao.queryOrderByUid(uid);
    }

    @Override
    public Order queryOrderByUidAndOid(String uid, String oid) {
        return orderDao.queryOrderByUidAndOid(uid, oid);
    }


    @Override
    public int updateOrder(Order o) {
        return updateOrder(o);
    }
}
