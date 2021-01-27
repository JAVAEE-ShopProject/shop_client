package com.igeek.shop.dao.impl;

import com.igeek.shop.dao.BaseDao;
import com.igeek.shop.dao.ProductDao;
import com.igeek.shop.pojo.Product;

import java.util.List;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/26 15:20
 * @description：
 * @version: 1.0
 */
public class ProductDaoImpl extends BaseDao<Product> implements ProductDao {
    @Override
    public List<Product> selectHotTop12() {
        String sql = "select * from product where is_hot = 1 limit 12";

        return queryList(sql,Product.class);
    }

    @Override
    public List<Product> selectLastTop12() {
        String sql = "select * from product order by pdate desc limit 12";
        return queryList(sql,Product.class);
    }

    @Override
    public int countByCid(Integer cid) {
        String sql = "select count(*) from product where cid = ?";
        Number o = (Number) querySingle(sql, cid);
        return o.intValue();
    }

    @Override
    public List<Product> pageByCid(Integer cid, int begin, int count) {
        String sql = "select * from product where cid = ?" +
                "  order by shop_price limit ?,?";
        return queryList(sql,Product.class,cid,begin,count);
    }

    @Override
    public int countByPname(String pname) {
        String sql = "select count(*) from product where pname like concat('%',?,'%')";
        Number o = (Number) querySingle(sql, pname);
        return o.intValue();
    }

    @Override
    public List<Product> pageByPname(String pname, int begin, int count) {
        String sql = "select * from product where " +
                " pname like concat('%',?,'%') order by shop_price limit ?,?";
        return queryList(sql,Product.class,pname,begin,count);
    }

}
