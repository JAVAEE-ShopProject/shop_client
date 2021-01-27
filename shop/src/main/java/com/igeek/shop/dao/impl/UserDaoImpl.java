package com.igeek.shop.dao.impl;

import com.igeek.shop.dao.BaseDao;
import com.igeek.shop.dao.UserDao;
import com.igeek.shop.pojo.User;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/25 18:25
 * @description：
 * @version: 1.0
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User queryUser(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        return queryOne(sql,User.class,username,password);
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into user values(?,?,?,?,?,?,?,?,0,?,?)";
        return update(sql,user.getUid(),user.getUsername(),
                user.getPassword(),user.getName(),user.getEmail(),
                user.getTelephone(),user.getBirthday(),
                user.getSex(),user.getCode(),user.getAddress());
    }

    @Override
    public int updateUserStateByCode(int state, String code) {
        String sql = "update user set state = ? where code = ?";
        return update(sql,state,code);
    }

    @Override
    public int updateUserPasswordByEmail(String password, String email) {
        String sql = "update user set password = ? where email = ?";
        return update(sql,password,email);
    }

    @Override
    public int queryCountByUsername(String username) {
        String sql = "select count(*) from user where username = ?";
        Number o = (Number) querySingle(sql, username);
        return o.intValue();
    }

}
