package Service;

import Bean.Party;
import Bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PartyUtil {
    public static ArrayList<Integer> getPersonsListAll(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ArrayList<Integer> persons = new ArrayList<>();
        try{
            connection = ConnectionUtil.ConnectMysql();
            String sql = "SELECT * FROM party_persons";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int party_id = rs.getInt("party_id");
                int user_id = rs.getInt("user_id");
                if(party_id == id){
                    persons.add(user_id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
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
        return persons;
    }


    public static ArrayList<Party> getPartyListAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ArrayList<Party> parties = new ArrayList<>();
        try{
            connection = ConnectionUtil.ConnectMysql();
            String sql = "SELECT * FROM party";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int party_id = rs.getInt("party_id");
                Date date = rs.getDate("date");
                String party_name = rs.getString("party_name");
                int person_number = rs.getInt("person_number");
                int fair = rs.getInt("fair");
                int is_bought = rs.getInt("is_bought");
                boolean isBought = false;
                if(is_bought == 1)
                    isBought = true;
                ArrayList<Integer> persons = getPersonsListAll(party_id);
                parties.add(new Party(party_id, date, party_name, person_number, fair, persons, isBought));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
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
        return parties;
    }

    public static String getPersonNames(ArrayList<Integer> persons){
        String s = "";
        for(int i:persons){
            s = s + " " + UserUtil.getUsernameById(i);
        }
        return s;
    }


}
