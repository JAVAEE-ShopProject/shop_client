package com.igeek.shop.service.impl;

import com.igeek.shop.dao.CategoryDao;
import com.igeek.shop.dao.ProductDao;
import com.igeek.shop.dao.impl.CategoryDaoImpl;
import com.igeek.shop.dao.impl.ProductDaoImpl;
import com.igeek.shop.pojo.Category;
import com.igeek.shop.pojo.Page;
import com.igeek.shop.pojo.Product;
import com.igeek.shop.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/26 15:28
 * @description：
 * @version: 1.0
 */
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();
    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Product> viewHotTop12() {
        return productDao.selectHotTop12();
    }
    @Override
    public List<Product> viewLastTop12() {
        return productDao.selectLastTop12();
    }

    @Override
    public List<Category> viewAllCategory() {
        return categoryDao.viewAllCategory();
    }

    @Override
    public Page<Product> pageByCid(int cid, int currentPageNumber, int pageSize) {
        Page<Product> page = new Page<>();

        //获取符合条件的记录数
        int count = productDao.countByCid(cid);
        //设置记录数
        page.setCount(count);
        //设置当前页号
        page.setCurrentPageNumber(currentPageNumber);
        //设置每页显示的记录数
        page.setPageSize(pageSize);
        //计算总页数
        int totalPages = (count % pageSize == 0)?(count / pageSize):(count / pageSize+1);
        //设置总页数
        page.setTotalPages(totalPages);
        //获取记录数 并设置
        List<Product> products = productDao.pageByCid(cid,
                (page.getCurrentPageNumber() - 1) * pageSize, pageSize);
        page.setItems(products);
        //设置查询条件
        Map<String,String> map = new HashMap<>();
        map.put("cid",cid+"");
        page.setQuery(map);
        return page;
    }

    @Override
    public Page<Product> pageByPname(String pname, int currentPageNumber, int pageSize) {
        Page<Product> page = new Page<>();

        //获取符合条件的记录数
        int count = productDao.countByPname( pname);
        //设置记录数
        page.setCount(count);
        //设置当前页号
        page.setCurrentPageNumber(currentPageNumber);
        //设置每页显示的记录数
        page.setPageSize(pageSize);
        //计算总页数
        int totalPages = (count % pageSize == 0)?(count / pageSize):(count / pageSize+1);
        //设置总页数
        page.setTotalPages(totalPages);
        //获取记录数 并设置
        List<Product> products = productDao.pageByPname(pname,
                (page.getCurrentPageNumber() - 1) * pageSize, pageSize);
        page.setItems(products);
        //设置查询条件
        Map<String,String> map = new HashMap<>();
        map.put("pname",pname);
        page.setQuery(map);
        return page;
    }

    @Override
    public int viewCategoryByCname(String cname) {
        Category category = categoryDao.viewCategoryByCname(cname);
        return category == null ? -1:category.getCid();
    }

    @Override
    public Product showDetailByPid(String pid) {
        return productDao.viewProductByPid(pid);
    }
}
