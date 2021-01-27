package com.igeek.shop.filter;

import com.igeek.shop.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/25 13:55
 * @description：
 * @version: 1.0
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {

            filterChain.doFilter(servletRequest, servletResponse);
            //提交事务
            JDBCUtils.closeAndCommit();
        } catch (Exception e) {
            //出现异常 回滚事务
            JDBCUtils.closeAndRoolback();
            //并将异常抛给 tomcat服务器 让其统一处理
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
