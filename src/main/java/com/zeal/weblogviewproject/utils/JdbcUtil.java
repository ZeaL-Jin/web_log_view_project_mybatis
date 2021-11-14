package com.zeal.weblogviewproject.utils;

import java.sql.*;

/**
 * @author ZEAL
 * jdbc的工具类
 */

public class JdbcUtil {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/oceandata";
    private static final String USER = "root";
    private static final String PASSWORD = "238612";

    /**
     * 封装SQL的Connection为一个方法
     *
     * @return 返回连接对象
     */
    public Connection getConnection() {
        try {
            //jdbc规范
            //1.导入jdbc的jar包
            //2.注册驱动
            Class.forName(DRIVER);
            //3.获取连接对象
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 静态方法，关闭资源
     *
     * @param connection 数据库连接
     * @param statement  数据库连接状态
     * @param resultSet  数据集
     */
    public void close(Connection connection, Statement statement, ResultSet resultSet) {
        //6.关闭资源
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
