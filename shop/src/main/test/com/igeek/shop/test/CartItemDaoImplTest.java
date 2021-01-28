package com.igeek.shop.test;

import com.igeek.shop.dao.CartItemDao;
import com.igeek.shop.dao.impl.CartItemDaoImpl;
import com.igeek.shop.pojo.Cart;
import com.igeek.shop.pojo.CartItem;
import com.igeek.shop.pojo.Product;
import com.igeek.shop.utils.JDBCUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/28 17:44
 * @description：
 * @version: 1.0
 */
public class CartItemDaoImplTest {

    CartItemDao cartItemDao = new CartItemDaoImpl();

    @Test
    public void addItemToCart() {

        System.out.println(cartItemDao.addItemToCart("1b4ca460e3bd4a3fa34b5d2bad90765a", 3, 2));
        JDBCUtils.closeAndCommit();

    }

    @Test
    public void updateItemCount() {

        System.out.println(cartItemDao.updateItemCountByCartIdAndPid("1b4ca460e3bd4a3fa34b5d2bad90765a", 3, 6));
        JDBCUtils.closeAndCommit();

    }


    @Test
    public void deleteItemFromCart() {
        cartItemDao.deleteItemFromCart("1b4ca460e3bd4a3fa34b5d2bad90765a",3);
        JDBCUtils.closeAndCommit();
    }

    @Test
    public void queryCartItemsFromCart() {
        List<Map<String, Object>> maps = cartItemDao.queryCartItemsMapListFromCart("1b4ca460e3bd4a3fa34b5d2bad90765a");
        System.out.println(maps);
    }
    @Test
    public void queryCartItemByCartIdAndPid(){
        Map<String, Object> cartItem = cartItemDao.queryCartItemByCartIdAndPid("f4fa1a25d6d945309fe0d4215fa95b77",16);
        System.out.println(cartItem);

    }
}