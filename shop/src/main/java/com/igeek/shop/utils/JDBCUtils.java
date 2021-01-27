package com.igeek.shop.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/15 14:21
 * @description：
 * @version: 1.0
 */
public class JDBCUtils {
    private static DruidDataSource ds = null;

    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    static {
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
     从数据库连接池中获取连接对象
     */
    public static Connection getConnection() {
        Connection conn = tl.get();
        if (conn == null) {
            try {
                conn = ds.getConnection();
                conn.setAutoCommit(false);
                tl.set(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 关闭连接对象
     */
    public static void closeAndRoolback() {
        Connection conn = tl.get();
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {

                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        //从该线程变量中移除 该连接
        tl.remove();


    }

    /**
     * 将事务提交
     */
    public static void closeAndCommit() {
        Connection conn = tl.get();
        if (conn != null) {
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
//从该线程变量中移除 该连接
        tl.remove();
    }
}
