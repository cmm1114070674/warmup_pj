package Dao;

import Bean.User;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class UserDao {
    public static void person_insert(User user){
        Connection connection = null;
        PreparedStatement statement = null;
        String username = user.getUsername();
        int money = user.getMoney();
        try {
            connection = ConnectionUtil.ConnectMysql();
            String sql = "INSERT INTO user(username, money) VALUES (?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setInt(2, money);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void person_update(int user_id, int money){
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "update user set money = ? where user_id = ?";
        try{
            connection = ConnectionUtil.ConnectMysql();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, money);
            statement.setInt(2, user_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
