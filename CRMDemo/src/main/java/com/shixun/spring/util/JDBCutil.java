package com.shixun.spring.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCutil {

    // 数据库连接驱动
    private static String driver = "com.mysql.jdbc.Driver";

    //数据连接URL地址
    private static String url = "jdbc:mysql://localhost:3306/qsx_register?useUnicode=true&characterEncoding=utf-8&useSSL=false";

    //数据库访问用户
    private static String user = "root";

    //数据库访问密码（根据实现密码值进行修改）
    private static String password = "wr980429";

    /**
     * 获得数据库连接
     * @return 数据库连接
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 注册驱动
            Class.forName(driver);
            // 获取连接
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            // 创建数据库连接异常的处理
            System.out.println("创建数据库连接异常");
        }
        return conn;
    }

    /**
     * 关闭数据库连接，释放资源
     * @param resultSet resultSet
     * @param statement statement
     * @param connection connection
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}