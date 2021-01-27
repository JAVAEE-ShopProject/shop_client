package com.igeek.shop.dao;

import com.igeek.shop.pojo.User;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/25 18:08
 * @description： 对用户表的访问接口
 * @version: 1.0
 */
public interface UserDao {
    /**
     *  通过 用户编号和密码 查询用户
     * @param username 用户名
     * @param password 用户密码
     * @return 查询成功 返回 User对象 查询失败 返回null
     *
     */
    User queryUser(String username,String password);

    /**
     * 添加用户
     * @param user 待添加的用户
     * @return  返回影响的行数
     */
    int addUser(User user);

    /**
     * 通过激活码 更改用户状态
     * @param state 用户状态
     * @param code 激活码
     * @return 返回影响的行数
     */
    int updateUserStateByCode(int state,String code);

    /**
     * 通过邮箱修改用户密码
     * @param password 用户密码
     * @param email 用户邮箱
     * @return 返回影响的行数
     */
    int updateUserPasswordByEmail(String password,String email);

    /**
     * 查询用户名为username的个数
     * @param username
     * @return
     */
    int queryCountByUsername(String username);

}
