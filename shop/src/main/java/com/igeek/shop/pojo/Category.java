package com.igeek.shop.pojo;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/26 15:50
 * @description：
 * @version: 1.0
 */
public class Category {

    private Integer cid;
    private String cname;

    public Category() {
    }

    public Category(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    /**
     * 获取
     * @return cid
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * 设置
     * @param cid
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * 获取
     * @return cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * 设置
     * @param cname
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    public String toString() {
        return "Category{cid = " + cid + ", cname = " + cname + "}";
    }
}
