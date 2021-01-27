package com.igeek.shop.pojo;

import java.util.List;
import java.util.Map;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/26 18:35
 * @description：
 * @version: 1.0
 */
public class Page<T> {

    //默认每页显示的记录个数
    public static Integer DEFAULT_SIZE = 12;

    //每页显示记录个数
    private Integer pageSize;

    //当前页号
    private Integer currentPageNumber;

    //总页数
    private Integer totalPages;

    //总记录数
    private Integer count;

    //记录集合
    private List<T> items;

    //请求的地址
    private String url;

    //查询条件
    private Map<String,String> query;


    public Page() {
    }

    public Page(Integer pageSize, Integer currentPageNumber, Integer totalPages, Integer count, List<T> items, String url, Map<String, String> query) {
        this.pageSize = pageSize;
        this.currentPageNumber = currentPageNumber;
        this.totalPages = totalPages;
        this.count = count;
        this.items = items;
        this.url = url;
        this.query = query;
    }

    /**
     * 获取
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取
     * @return currentPageNumber
     */
    public Integer getCurrentPageNumber() {
        return currentPageNumber;
    }

    /**
     * 设置
     * @param currentPageNumber
     */
    public void setCurrentPageNumber(Integer currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    /**
     * 获取
     * @return totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * 设置
     * @param totalPages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * 获取
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取
     * @return items
     */
    public List<T> getItems() {
        return items;
    }

    /**
     * 设置
     * @param items
     */
    public void setItems(List<T> items) {
        this.items = items;
    }

    /**
     * 获取
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取
     * @return query
     */
    public Map<String, String> getQuery() {
        return query;
    }

    /**
     * 设置
     * @param query
     */
    public void setQuery(Map<String, String> query) {
        this.query = query;
    }

    public String toString() {
        return "Page{pageSize = " + pageSize + ", currentPageNumber = " + currentPageNumber + ", totalPages = " + totalPages + ", count = " + count + ", items = " + items + ", url = " + url + ", query = " + query + "}";
    }
}
