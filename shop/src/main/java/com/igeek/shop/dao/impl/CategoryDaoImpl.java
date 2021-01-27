package com.igeek.shop.dao.impl;

import com.igeek.shop.dao.BaseDao;
import com.igeek.shop.dao.CategoryDao;
import com.igeek.shop.pojo.Category;

import java.util.List;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/26 15:52
 * @description：
 * @version: 1.0
 */
public class CategoryDaoImpl extends BaseDao<Category> implements CategoryDao {
    @Override
    public List<Category> viewAllCategory() {
        String sql = "select * from category";
        return queryList(sql,Category.class);
    }

    @Override
    public Category viewCategoryByCname(String cname) {
        String sql = "select * from category where cname = ?";
        return queryOne(sql,Category.class,cname);
    }
}
