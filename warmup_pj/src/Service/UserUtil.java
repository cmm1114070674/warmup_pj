package Service;

import Bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class UserUtil {
    public static ArrayList<User> getUserListAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ArrayList<User> users = new ArrayList<>();
        try{
            connection = ConnectionUtil.ConnectMysql();
            String sql = "SELECT * FROM user";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int user_id = rs.getInt("user_id");
                String username = rs.getString("username");
                int money = rs.getInt("money");
                users.add(new User(user_id, username, money));
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
        return users;
    }

    public static String getUsernameById(int user_id){
        String username = "";
        for(User i:getUserListAll()){
            if(i.getUser_id() == user_id)
                username = i.getUsername();
        }
        return username;
    }

    public static int getSum(){
        int sum = 0;
        for(User i:getUserListAll()){
            sum = sum + i.getMoney();
        }
        return sum;
    }

    public static User getUserById(int user_id){
        String username = "";
        int money = 0;
        for(User i:getUserListAll()){
            if(i.getUser_id() == user_id) {
                username = i.getUsername();
                money = i.getMoney();
            }
        }
        User user = new User(user_id, username, money);
        return user;
    }


}
