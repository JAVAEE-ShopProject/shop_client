package com.igeek.shop.dao;

import com.igeek.shop.pojo.Product;

import java.util.List;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/26 15:16
 * @description：
 * @version: 1.0
 */
public interface ProductDao {

    /**
     * 查询最热门商品的前12
     * @return 集合
     */
    List<Product> selectHotTop12();

    /**
     * 返回最新商品的前12
     * @return
     */
    List<Product> selectLastTop12();

    /**
     * 查询种类是Cid产品名记录数
     * @return
     */
    int countByCid(Integer cid);


    /**
     *查询种类是cid的 最后按价格升序排列
     * @param cid 产品的种类编号
     * @param begin  起始索引
     * @param count 查询个数
     * @return 查询的集合 没有返回null
     */
    List<Product> pageByCid(Integer cid,int begin,int count);

    /**
     * 查询产品名中包含Pname的记录数
     * @return
     */
    int countByPname(String pname);


    /**
     *查询商品名中含有pname的 最后按价格升序排列
     * @param pname 产品的名称 采用模糊查询
     * @param begin  起始索引
     * @param count 查询个数
     * @return 查询的集合 没有返回null
     */
    List<Product> pageByPname(String pname,int begin,int count);
}
