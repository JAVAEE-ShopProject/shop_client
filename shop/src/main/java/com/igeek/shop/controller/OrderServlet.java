package com.igeek.shop.controller;

import com.igeek.shop.pojo.*;
import com.igeek.shop.service.CartService;
import com.igeek.shop.service.OrderService;
import com.igeek.shop.service.impl.CartServiceImpl;
import com.igeek.shop.service.impl.OrderServiceImpl;
import com.igeek.shop.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/30 14:35
 * @description：
 * @version: 1.0
 */
@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends BaseServlet {
    private CartService cartService = new CartServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

    /**
     * 创建订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] pids = req.getParameterValues("pid");
        HttpSession session = req.getSession();
        if (pids != null) {
            User user = (User) session.getAttribute("user");
            //通过用户编号 获取购物车信息
            Cart cart = cartService.queryCartByUid(user.getUid());
            List<OrderItem> orderItems = new ArrayList<>();
            Order o = new Order();
            double total = 0;
            for (String pid : pids) {
                CartItem cartItem = cartService.queryCartItemByCartIdAndPid(cart.getCartId(), pid);
                //购物车中删除指定商品
                cartService.deleteItemFromCart(cart.getCartId(), pid);
                //创建订单商品项
                OrderItem orderItem = new OrderItem(WebUtils.randomStr(), cartItem.getCount(),
                        cartItem.getTotalPrice(), cartItem.getProduct(), o);
                orderItems.add(orderItem);
                //累计订单总金额
                total += cartItem.getTotalPrice();
            }

            o.setOid(WebUtils.randomStr());
            //设置用户信息
            o.setUser(user);
            //设置订单创建时间
            o.setOrdertime(new Date());
            //设置总金额
            o.setTotal(total);
            //设置订单项
            o.setOrderItems(orderItems);
//            int i = 10 / 0;
            //创建订单
            orderService.createOrder(o);
            //将订单信息放入会话域中 不可放入请求域中  存在重复提交的问题
            session.setAttribute("order", o);
            //重定向到确认订单页面
            resp.sendRedirect(req.getContextPath() + "/pages/order/confirm_order.jsp");
            return;
        }
        //没填写要买的商品号即pid
        resp.sendRedirect(req.getHeader("referer"));

    }

    /**
     * 显示我的订单列表
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * 显示订单详情
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrderInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void confirmOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Order order = (Order) req.getSession().getAttribute("order");
        String name = WebUtils.getStr(req.getParameter("name"));
        String address = WebUtils.getStr(req.getParameter("address"));
        String telephone = WebUtils.getStr(req.getParameter("telephone"));
        order.setName(name);
        order.setAddress(address);
        order.setTelephone(telephone);
        //更新订单信息
        orderService.updateOrder(order);
        String pay = WebUtils.getStr(req.getParameter("pay"));
        if (pay.equals("alipay")) {
            //支付宝跳转到支付宝支付页面
            req.getRequestDispatcher("/pages/alipay/alipay.trade.page.pay.jsp").forward(req, resp);
        } else if (pay.equals("wechatPay")) {
            //微信支付跳转到微信支付页面


        }


    }


}
