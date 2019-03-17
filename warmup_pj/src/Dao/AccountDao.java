package Dao;

import Bean.Account;
import Bean.User;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class AccountDao {
    public static void account_insert(Account account){
        Connection connection = null;
        PreparedStatement statement = null;
        int party_id = account.getParty_id();
        Date date = account.getDate();
        java.sql.Date sdate = new java.sql.Date(date.getTime());
        int user_id = account.getUser_id();
        try {
            connection = ConnectionUtil.ConnectMysql();
            String sql = "INSERT INTO account(party_id, user_id, date) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, party_id);
            statement.setInt(2, user_id);
            statement.setDate(3, sdate);
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

}
