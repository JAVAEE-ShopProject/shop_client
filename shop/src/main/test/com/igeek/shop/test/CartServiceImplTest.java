package com.igeek.shop.test;

import com.igeek.shop.pojo.Cart;
import com.igeek.shop.pojo.CartItem;
import com.igeek.shop.service.CartService;
import com.igeek.shop.service.impl.CartServiceImpl;
import com.igeek.shop.utils.JDBCUtils;
import com.igeek.shop.utils.WebUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/28 18:41
 * @description：
 * @version: 1.0
 */
public class CartServiceImplTest {

    CartService cartService = new CartServiceImpl();

    @Test
    public void createCart() {

        cartService.createCart(WebUtils.randomStr(),"5e85111b049c4e3c84283beb83c2a4da");
        JDBCUtils.closeAndCommit();
    }

    @Test
    public void queryCartByUid() {
        Cart cart = cartService.queryCartByUid("5e85111b049c4e3c84283beb83c2a4da");
        System.out.println(cart);
    }

    @Test
    public void addItemToCart() {

        cartService.addItemToCart("f4fa1a25d6d945309fe0d4215fa95b77","11",12);
        JDBCUtils.closeAndCommit();

    }

    @Test
    public void updateItemCountByCartIdAndPid() {

        cartService.updateItemCountByCartIdAndPid("f4fa1a25d6d945309fe0d4215fa95b77","101",2);
        JDBCUtils.closeAndCommit();
    }

    @Test
    public void deleteItemFromCart() {

        cartService.deleteItemFromCart("f4fa1a25d6d945309fe0d4215fa95b77","1");
        JDBCUtils.closeAndCommit();
    }

    @Test
    public void queryCartItemsFromCart() {
        List<CartItem> cartItems = cartService.queryCartItemsFromCart("f4fa1a25d6d945309fe0d4215fa95b77");
        System.out.println(cartItems);

    }

    @Test
    public void queryCartItemFromCart() {
        CartItem cartitem = cartService.queryCartItemByCartIdAndPid("f4fa1a25d6d945309fe0d4215fa95b77", "1");

        System.out.println(cartitem);

    }

    @Test
    public void clearCart() {
        System.out.println(cartService.clearCart("f4fa1a25d6d945309fe0d4215fa95b77"));
        JDBCUtils.closeAndCommit();

    }
}