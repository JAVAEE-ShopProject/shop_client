package com.igeek.shop.dao;

import com.igeek.shop.pojo.Category;

import java.util.List;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/26 15:48
 * @description：
 * @version: 1.0
 */
public interface CategoryDao {

    /**
     * 查询所有的种类
     * @return
     */
    List<Category> viewAllCategory();
    /**
     * 通过商品种类名称获取商品种类
     * @param cname 商品名称
     * @return 返回null代表未查找到
     */
    Category viewCategoryByCname(String cname);

}
