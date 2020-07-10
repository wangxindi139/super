package com.goods.util;

import java.sql.*;

public class ShopUtil {

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


//链接数据库
    public static Connection getConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url+"?user="+user+"&password="+password);
    }

    public static Connection getConnection(String STATICURL) throws SQLException{
        return DriverManager.getConnection(STATICURL);
    }

    public static void release(ResultSet resultSet,PreparedStatement preparedStatement,Connection connection){
        if (connection != null) {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}


