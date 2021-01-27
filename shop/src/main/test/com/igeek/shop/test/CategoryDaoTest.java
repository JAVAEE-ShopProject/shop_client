package com.igeek.shop.test;

import com.igeek.shop.dao.CategoryDao;
import com.igeek.shop.dao.impl.CategoryDaoImpl;
import com.igeek.shop.pojo.Category;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/26 23:52
 * @description：
 * @version: 1.0
 */
public class CategoryDaoTest {


    CategoryDao categoryDao = new CategoryDaoImpl();
    @Test
    public void viewCategoryByCname() {
        Category category = categoryDao.viewCategoryByCname("手机数码11");
        System.out.println(category);
    }
}