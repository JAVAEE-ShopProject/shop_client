package com.igeek.shop.pojo;

import java.util.Date;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/24 9:51
 * @description：
 * @version: 1.0
 */
public class User {
    private String name;
    private Date birthDay;
    private Integer age;

    public User() {
    }

    public User(String name, Date birthDay, Integer age) {
        this.name = name;
        this.birthDay = birthDay;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return birthDay
     */
    public Date getBirthDay() {
        return birthDay;
    }

    /**
     * 设置
     * @param birthDay
     */
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "User{name = " + name + ", birthDay = " + birthDay + ", age = " + age + "}";
    }
}
