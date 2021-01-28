package com.igeek.shop.test;

import com.igeek.shop.dao.CartDao;
import com.igeek.shop.dao.impl.CartDaoImpl;
import com.igeek.shop.pojo.Cart;
import com.igeek.shop.utils.JDBCUtils;
import com.igeek.shop.utils.WebUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/28 17:45
 * @description：
 * @version: 1.0
 */
public class CartDaoTest {
    CartDao cartDao = new CartDaoImpl();
    @Test
    public void createCart() {
        System.out.println(cartDao.createCart(WebUtils.randomStr(), "5e85111b049c4e3c84283beb83c2a4da"));
        JDBCUtils.closeAndCommit();
    }

    @Test
    public void queryCartByUid() {
        Cart cart = cartDao.queryCartByUid("5e85111b049c4e3c84283beb83c2a4da");
        System.out.println(cart);

    }
}