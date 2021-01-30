package com.igeek.shop.test;

import com.igeek.shop.dao.OrderDao;
import com.igeek.shop.dao.impl.OrderDaoImpl;
import com.igeek.shop.pojo.Order;
import com.igeek.shop.pojo.OrderItem;
import com.igeek.shop.pojo.Product;
import com.igeek.shop.pojo.User;
import com.igeek.shop.utils.JDBCUtils;
import com.igeek.shop.utils.WebUtils;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/30 10:01
 * @description：
 * @version: 1.0
 */
public class OrderDaoImplTest {

    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void createOrder() {
        User user = new User();
        user.setUid("5e85111b049c4e3c84283beb83c2a4da");
        Order order = new Order(WebUtils.randomStr(),new Date(),777.0,0,
                null,null,null,user,null);
        orderDao.createOrder(order);
        JDBCUtils.closeAndCommit();
    }

    @Test
    public void addOrderItem() {

        Order o = new Order();
        o.setOid("e1604a41dcd74f898d2eb2c7f176a1a8");
        Product p = new Product();
        p.setPid("1");
        OrderItem orderItem = new OrderItem(WebUtils.randomStr(),2,4000,p,o);
        orderDao.addOrderItem(orderItem);
        JDBCUtils.closeAndCommit();
    }

    @Test
    public void queryMapListByOid() {

        List<Map<String, Object>> list = orderDao.queryOrderItemsMapListByOid("e1604a41dcd74f898d2eb2c7f176a1a8");
        System.out.println(list);
    }

    @Test
    public void updateByOid() {

        List<Map<String, Object>> list = orderDao.queryOrderItemsMapListByOid("e1604a41dcd74f898d2eb2c7f176a1a8");
        List<OrderItem> items = new ArrayList<>();
        for (Map<String, Object> map : list) {
            Product product = WebUtils.parseMapToBean(new Product(), map);
            OrderItem orderItem = WebUtils.parseMapToBean(new OrderItem(), map);
            orderItem.setProduct(product);
            items.add(orderItem);
        }
        System.out.println(items);


//        System.out.println(list);
    }

    @Test
    public void queryOrderByUid(){
        List<Order> orders = orderDao.queryOrderByUid("5e85111b049c4e3c84283beb83c2a4da");
        System.out.println(orders);
    }



}