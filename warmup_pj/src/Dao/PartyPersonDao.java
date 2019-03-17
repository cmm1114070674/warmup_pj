package Dao;

import Bean.Party;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PartyPersonDao {
    public static void party_insert(Party party){
        Connection connection = null;
        PreparedStatement statement = null;
        int party_id = party.getParty_id();
        ArrayList<Integer> persons = party.getPersons();
        for(int i:persons){
            try {
                connection = ConnectionUtil.ConnectMysql();
                String sql = "INSERT INTO party_persons(party_id, user_id) VALUES (?, ?)";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, party_id);
                statement.setInt(2, i);
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
}
