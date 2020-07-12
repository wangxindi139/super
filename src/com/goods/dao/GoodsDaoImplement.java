package com.goods.dao;
import com.goods.entity.Goods;
import com.goods.util.ShopUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.Callable;


public class GoodsDaoImplement implements GoodsDao {
    final String URL = "jdbc:mariadb://localhost:3306/mysqldb";
    final String USER = "root";
    final String PASSWORD = "mariadb";

    //浏览商品信息
    @Override
    public boolean showGoods() {
        boolean result = false;
        Connection collection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select *from goods;";
        try {
            collection = ShopUtil.getConnection(URL,USER,PASSWORD);
            preparedStatement = collection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("ID\t\t\t商品编码\t\t\t商品名");
            while (resultSet.next()){
                Goods goods = new Goods(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3));
                System.out.println(goods);
                result = true;
            } ;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ShopUtil.release(resultSet,preparedStatement,collection);
        }

        return result;
    }
//增加商品
    @Override
    public boolean addGoods(Goods goods) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ShopUtil.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "insert into goods(Pro_ld, S_ku, Title) value (?,?,?);";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goods.getId());
            preparedStatement.setInt(2,goods.getBm());
            preparedStatement.setString(3,goods.getName());
            int rs = preparedStatement.executeUpdate();
            if (rs == 1){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ShopUtil.release(null,preparedStatement,connection);
        }
        return result;
    }

    //删除商品
    @Override
    public boolean delectGoods(int id) {
        Scanner scanner = new Scanner(System.in);
        boolean result = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ShopUtil.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "delete from goods where Pro_ld = ?;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int rs = preparedStatement.executeUpdate();
            if (rs == 1){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ShopUtil.release(null,preparedStatement,connection);
        }
        return result;
    }

    //修改商品
    @Override
    public boolean modifyGoods(Goods goods) {
        boolean result = false;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ShopUtil.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "update goods set Pro_ld = ?,S_ku = ?,Title = ? where Pro_ld = ?;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goods.getId());
            preparedStatement.setInt(2,goods.getBm());
            preparedStatement.setString(3,goods.getName());
            int rs = preparedStatement.executeUpdate();

            if (rs == 1){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ShopUtil.release(null,preparedStatement,connection);
        }
        return result;
    }


    //按编号查找
    @Override
    public boolean selectGoodsId(int id) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ShopUtil.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "select * from goods where Pro_ld = ?;";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Goods goods = new Goods(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3));
                if (resultSet.getString(1) != null) {
                    System.out.println("id\t编号\t品名");
                    System.out.println(goods);
                    result = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ShopUtil.release(resultSet,preparedStatement,connection);
        }
        return result;
    }
}