package com.igeek.shop.controller;

import com.igeek.shop.pojo.Cart;
import com.igeek.shop.pojo.CartItem;
import com.igeek.shop.pojo.Product;
import com.igeek.shop.pojo.User;
import com.igeek.shop.service.CartService;
import com.igeek.shop.service.ProductService;
import com.igeek.shop.service.impl.CartServiceImpl;
import com.igeek.shop.service.impl.ProductServiceImpl;
import com.igeek.shop.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/28 22:00
 * @description：
 * @version: 1.0
 */
@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends BaseServlet {
    private CartService cartService = new CartServiceImpl();
    private ProductService productService = new ProductServiceImpl();

    protected void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //从请求中获取商品编号
        String pid = WebUtils.getStr(req.getParameter("pid"));
        Integer count = WebUtils.parseStr2Int(req.getParameter("count"), -1);
        if (count != -1 && !"".equals(pid)) {
            User user = (User) req.getSession().getAttribute("user");
            Cart cart = cartService.queryCartByUid(user.getUid());
            Product product = productService.showDetailByPid(pid);
            //跳转到添加成功页面
            cartService.addItemToCart(cart.getCartId(), pid, count);
            //将购物车商品项存放到请求域中
            CartItem cartItem = new CartItem(cart, product, count, product.getShop_price() * count);
            req.setAttribute("cartItem", cartItem);
            //请求转发到 添加成功页面
            req.getRequestDispatcher("/pages/cart/cartSuccess.jsp").forward(req, resp);
        }else{
            resp.sendRedirect(req.getHeader("referer"));
        }
    }

    protected void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Cart cart = cartService.queryCartByUid(user.getUid());
        //获取商品列表项
        List<CartItem> cartItems = cartService.queryCartItemsFromCart(cart.getCartId());
        cart.setItems(cartItems);
        cart.setUser(user);
        req.setAttribute("cart", cart);
        req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req, resp);
    }

    protected void clearCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Cart cart = cartService.queryCartByUid(user.getUid());
        //清空购物车
        cartService.clearCart(cart.getCartId());
        //相应重定向到 购物车页面
        resp.sendRedirect(req.getContextPath() + "/cart?method=showCart");

    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从请求中获取商品编号
        String pid = WebUtils.getStr(req.getParameter("pid"));
        Integer count = WebUtils.parseStr2Int(req.getParameter("count"), -1);
        if (count != -1 && !"".equals(pid)) {
            User user = (User) req.getSession().getAttribute("user");
            Cart cart = cartService.queryCartByUid(user.getUid());
            //跳转到添加成功页面
            cartService.updateItemCountByCartIdAndPid(cart.getCartId(), pid, count);
            //请求转发到 购物车页面
            resp.sendRedirect(req.getContextPath() + "/cart?method=showCart");
        }else{
            resp.sendRedirect(req.getHeader("referer"));
        }
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从请求中获取商品编号
        String pid = WebUtils.getStr(req.getParameter("pid"));
        if(pid.equals("")){
            resp.sendRedirect(req.getHeader("referer"));
            return;
        }
        User user = (User) req.getSession().getAttribute("user");
        Cart cart = cartService.queryCartByUid(user.getUid());
        //跳转到添加成功页面
        cartService.deleteItemFromCart(cart.getCartId(), pid);
        //请求转发到 购物车页面
        resp.sendRedirect(req.getContextPath() + "/cart?method=showCart");
    }


}
