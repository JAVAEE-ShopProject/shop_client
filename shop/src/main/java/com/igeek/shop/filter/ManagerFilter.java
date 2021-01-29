package com.igeek.shop.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/29 11:11
 * @description：
 * @version: 1.0
 */
public class ManagerFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Object user = ((HttpServletRequest) request).getSession().getAttribute("user");
        if(user == null){
            ((HttpServletResponse)response).sendRedirect(((HttpServletRequest) request).getContextPath()+"/pages/user/login.jsp");
            return;
        }
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
