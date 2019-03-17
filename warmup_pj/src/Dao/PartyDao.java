package Dao;

import Bean.Party;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PartyDao {
    public static void party_insert(Party party){
        Connection connection = null;
        PreparedStatement statement = null;
        int party_id = party.getParty_id();
        Date date = party.getDate();
        java.sql.Date sdate = new java.sql.Date(date.getTime());
        String party_name = party.getParty_name();
        int person_number = party.getPerson_number();
        int fair = party.getFair();
        ArrayList<Integer> persons = party.getPersons();
        boolean isBought = party.isBought();
        int is_bought = -1;
        if(isBought)
            is_bought = 1;
        else
            is_bought = 0;
        try {
            connection = ConnectionUtil.ConnectMysql();
            String sql = "INSERT INTO party(date, party_name, person_number, fair, is_bought) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setDate(1, sdate);
            statement.setString(2, party_name);
            statement.setInt(3, person_number);
            statement.setInt(4, fair);
            statement.setInt(5, is_bought);
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

    public static void party_update(int party_id){
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isBought = false;
        int is_bought = 1;
        String sql = "update party set is_bought = ? where party_id = ?";
        try{
            connection = ConnectionUtil.ConnectMysql();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, is_bought);
            statement.setInt(2, party_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
