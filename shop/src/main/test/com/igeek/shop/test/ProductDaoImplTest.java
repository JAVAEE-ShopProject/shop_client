package com.igeek.shop.test;

import com.igeek.shop.dao.ProductDao;
import com.igeek.shop.dao.impl.ProductDaoImpl;
import com.igeek.shop.pojo.Product;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/26 15:24
 * @description：
 * @version: 1.0
 */
public class ProductDaoImplTest {
    ProductDao productDao = new ProductDaoImpl();

    @Test
    public void selectHotTop12() {
        System.out.println(productDao.selectHotTop12());
    }

    @Test
    public void selectLastTop12() {


        System.out.println(productDao.selectLastTop12());
    }

   /* @Test
    public void countByCidAndByPname(){
        int count = productDao.countByCidAndPname(1, "");
        System.out.println(count);
    }
    @Test
    public void pageByCidAndPname(){
        List<Product> apple = productDao.pageByCidAndPname(1, "小", 0, 12);
        System.out.println(apple);

    }
*/
   @Test
    public void pageByPname(){
        int count = productDao.countByPname("");
        System.out.println(count);
        List<Product> products = productDao.pageByPname("", 0, 12);
        System.out.println(products);
    }


}