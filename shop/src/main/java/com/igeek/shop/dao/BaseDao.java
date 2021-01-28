package com.igeek.shop.dao;

import com.igeek.shop.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/15 14:34
 * @description：
 * @version: 1.0
 */
public abstract class BaseDao<T> {

    private QueryRunner runner = new QueryRunner();


    //修改
    public int update(String sql, Object... params) {
        try {
            return runner.update(JDBCUtils.getConnection(), sql, params);
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public T queryOne(String sql, Class<T> type, Object... params) {
        try {
            return runner.query(JDBCUtils.getConnection(), sql, new BeanHandler<>(type), params);
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<T> queryList(String sql, Class<T> type, Object... params) {

        try {
            return runner.query(JDBCUtils.getConnection(), sql, new BeanListHandler<>(type), params);
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Object querySingle(String sql,Object... params) {

        try {
            return runner.query(JDBCUtils.getConnection(), sql, new ScalarHandler(), params);
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public List<Map<String,Object>> queryListMap(String sql,Object... params){
        try {
            return runner.query(JDBCUtils.getConnection(), sql, new MapListHandler(), params);
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Map<String,Object> queryMap(String sql,Object... params){
        try {
            return runner.query(JDBCUtils.getConnection(), sql, new MapHandler(), params);
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
