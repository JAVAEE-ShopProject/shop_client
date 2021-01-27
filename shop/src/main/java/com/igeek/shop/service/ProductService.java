package com.igeek.shop.service;

import com.igeek.shop.pojo.Category;
import com.igeek.shop.pojo.Page;
import com.igeek.shop.pojo.Product;

import java.util.List;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/26 15:25
 * @description：
 * @version: 1.0
 */
public interface ProductService {


    /**
     * 查询最热门商品的前12
     * @return 集合
     */
    List<Product> viewHotTop12();

    /**
     * 返回最新商品的前12
     * @return
     */
    List<Product> viewLastTop12();

    /**
     * 查询所有的商品种类
     * @return
     */
    List<Category> viewAllCategory();

    /**
     * 根据商品编号 分页查询 符合条件的记录
     * @param cid  商品种类编号
     * @param currentPageNumber 当前页
     * @param pageSize   每页显示记录个数
     * @return 查询成功 返回 Page对象
     */
    Page<Product>  pageByCid(int cid,int currentPageNumber,int pageSize);

    /**
     * 根据商品名分页查询 符合条件的记录
     * @param pname 商品名 可以模糊查询
     * @param currentPageNumber 当前页
     * @param pageSize   每页显示记录个数
     * @return 查询成功 返回 Page对象
     */
    Page<Product>  pageByPname(String pname,int currentPageNumber,int pageSize);

    /**
     * 通过商品种类名称获取商品编号
     * @param cname 商品名称
     * @return 返回-1代表未查找到
     */
    int viewCategoryByCname(String cname);

    /**
     * 通过pid查询商品的信息
     * @param pid 商品编号
     * @return null代表无此记录
     */
    Product showDetailByPid(String pid);

}
