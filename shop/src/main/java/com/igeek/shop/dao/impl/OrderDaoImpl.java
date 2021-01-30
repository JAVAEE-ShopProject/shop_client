package com.igeek.shop.dao.impl;

import com.igeek.shop.dao.BaseDao;
import com.igeek.shop.dao.OrderDao;
import com.igeek.shop.pojo.Order;
import com.igeek.shop.pojo.OrderItem;

import java.util.List;
import java.util.Map;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/30 9:37
 * @description：
 * @version: 1.0
 */
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {
    @Override
    public int createOrder(Order order) {
        String sql = "insert into orders values(?,?,?,0,null,null,null,?)";
        return update(sql,order.getOid(),order.getOrdertime(),
                order.getTotal(),order.getUser().getUid());
    }

    @Override
    public int addOrderItem(OrderItem item) {
        String sql = "insert into orderItem values(?,?,?,?,?)";
        return update(sql,item.getItemid(),item.getCount(),
                item.getSubtotal(),item.getProduct().getPid(),item.getOrder().getOid());
    }

    @Override
    public List<Map<String, Object>> queryOrderItemsMapListByOid(String oid) {
        String sql = "select * from orderItem i inner join product p on i.pid=p.pid where i.oid = ? ";
        return queryListMap(sql,oid);
    }

    @Override
    public List<Order> queryOrderByUid(String uid) {
        String sql = "select * from orders where uid = ?";
        return queryList(sql,Order.class,uid);
    }

    @Override
    public Order queryOrderByUidAndOid(String uid, String oid) {
        String sql  = "select * from orders where uid = ? and oid = ?";
        return queryOne(sql,Order.class,uid,oid);
    }

    @Override
    public int updateOrder(Order o) {
        String sql = "update orders set ordertime = ?,total = ?,state = ?,address = ?,name = ?,telephone = ? ,uid = ? where oid = ?";
        return update(sql,o.getOrdertime(),o.getTotal(),o.getState(),o.getAddress(),o.getName(),o.getTelephone(),o.getUser().getUid(),o.getOid());
    }
}
