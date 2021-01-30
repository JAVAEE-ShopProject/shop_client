package com.igeek.shop.controller;

import com.igeek.shop.pojo.User;
import com.igeek.shop.service.UserService;
import com.igeek.shop.service.impl.UserServiceImpl;
import com.igeek.shop.utils.MD5Utils;
import com.igeek.shop.utils.MailUtils;
import com.igeek.shop.utils.WebUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/25 18:39
 * @description： 用户模块的控制器
 * @version: 1.0
 */
@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 登录
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        //使用md5 获得MD5字符串
        String password = MD5Utils.md5(req.getParameter("password"));
        //通过用户名和密码查询用户是否存在
        User user = userService.queryUser(username, password);
        if (user == null) {
            //登录失败
            req.setAttribute("msg", "用户名或密码错误");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        //用户存在 根据状态码 执行相应的逻辑
        Integer state = user.getState();
        if (state == 0) {
            //等于0代表未激活
            req.setAttribute("msg", "账号未激活,请查看邮箱，激活账号");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else if (state == 1) {
            //等于1已激活 登录成功 保存用户信息到session域中
            req.getSession().setAttribute("user", user);
            //其他业务  免登录 记住用户名

            //响应重定向到主页
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }

    /**
     * 注册
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //从请求中获取验证码
        String code = req.getParameter("code");

        HttpSession session = req.getSession();
        System.out.println(req.getParameter("birthday"));
        //从请求参数中获取user对象
        User user = WebUtils.parseMapToBean(new User(), req.getParameterMap());
        System.out.println(user);
        if (code.equals(session.getAttribute("KAPTCHA_SESSION_KEY"))) {
            //验证码正确 移除验证码 避免表单重复提交
            session.removeAttribute("KAPTCHA_SESSION_KEY");

            //生成用户uid
            user.setUid(WebUtils.randomStr());
            //对用户密码 使用MD5算法 生成md5字符串
            user.setPassword(MD5Utils.md5(user.getPassword()));
            //生成用户激活码
            String codeStr = WebUtils.randomStr();
            user.setCode(codeStr);
            userService.addUser(user);
            System.out.println(user);
            //生成激活账号链接
            String path = req.getScheme()+"://"+req.getServerName()+
                    ":"+req.getServerPort()+req.getContextPath()+"/"+"user?method=active&code="+codeStr;
            //发送邮件到用户邮箱 让其激活账户
            String msg = "<a href = \""+path+"\">"+codeStr+"</a>";
            try {
                MailUtils.sendMail(user.getEmail(),"激活账号",msg);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            //重定向到 注册成功页面
            resp.sendRedirect(req.getContextPath()+"/pages/user/registSuccess.jsp");
        }else{
            //回显错误信息
            req.setAttribute("codeMsg","验证码错误");
            //回显用户信息
            req.setAttribute("user",user);
            //验证码错误 请求转发到注册页面
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req,resp);

        }
    }
    protected void active(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("用户激活");
        //获取激活码
        String code = req.getParameter("code");
        //检查激活码是否合法
        if(WebUtils.checkRange(code)){
            //激活用户
            userService.updateUserStateByCode(1, code);
            //重定向到激活成功页面
            resp.sendRedirect(req.getContextPath()+"/pages/user/activeSuccess.jsp");
        }
    }


        /**
         * 退出登录
         *
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从会话中移除用户信息
        req.getSession().removeAttribute("user");
        //请求转发到首页
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }

    /**
     * 验证用户名 是否存在
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void validateName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean isValid = userService.isValidUsername(username);
        String jsonStr = "{\"isValid\":" + isValid + "}";
        /*
         * 此处的key必须用双引号  >>> "key"
         * */
        System.out.println(jsonStr);
        resp.getWriter().write(jsonStr);
    }



}
