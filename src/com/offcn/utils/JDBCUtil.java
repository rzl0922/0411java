package com.offcn.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// 工具类  目的是通过连接池获得连接
public class JDBCUtil {
    //声明数据源
    private static DataSource ds = null;
    //1.获取数据源
    public static DataSource getDataSource(){
        Properties ps = new Properties();
        //读取配置文件中的内容
        Class clazz = JDBCUtil.class;
        //使用该方法，前面需要加/表示在src下面
        InputStream is = clazz.getResourceAsStream("/druid.properties");
        try {
            ps.load(is);
            //获取数据源的方法。
            ds = DruidDataSourceFactory.createDataSource(ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    // 获取连接
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 释放资源
    public static void close(Connection conn, Statement st, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn,Statement st){
        close(conn,st,null);
    }
}
