package Service;

import Bean.Account;
import Bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class AccountUtil {
    public static ArrayList<Account> getAccountListAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ArrayList<Account> accounts = new ArrayList<>();
        try{
            connection = ConnectionUtil.ConnectMysql();
            String sql = "SELECT * FROM account";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int party_id = rs.getInt("party_id");
                int user_id = rs.getInt("user_id");
                Date date = rs.getDate("date");
                accounts.add(new Account(party_id, user_id, date));
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
        return accounts;
    }

    public static String getPersonByPartyId(int party_id){
        String s = "";
        int user_id = 0;
        for(Account i:getAccountListAll()){
            if(i.getParty_id() == party_id)
                user_id = i.getUser_id();
        }
        s = UserUtil.getUsernameById(user_id);
        return s;
    }



}
