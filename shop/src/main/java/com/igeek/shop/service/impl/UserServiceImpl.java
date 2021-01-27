package com.igeek.shop.service.impl;

import com.igeek.shop.dao.UserDao;
import com.igeek.shop.dao.impl.UserDaoImpl;
import com.igeek.shop.pojo.User;
import com.igeek.shop.service.UserService;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/25 18:35
 * @description：
 * @version: 1.0
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User queryUser(String username, String password) {
        return userDao.queryUser(username,password);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int updateUserStateByCode(int state, String code) {
        return userDao.updateUserStateByCode(state,code);
    }

    @Override
    public int updateUserPasswordByEmail(String password, String email) {
        return userDao.updateUserPasswordByEmail(password,email);
    }

    @Override
    public boolean isValidUsername(String username) {
        int count = userDao.queryCountByUsername(username);
        return count == 0;
    }
}
