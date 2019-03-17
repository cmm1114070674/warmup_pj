package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import static java.sql.DriverManager.getConnection;

public class ConnectionUtil {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String CONNECTION = "jdbc:mysql://localhost/warmup_pj?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection ConnectMysql(){
        try{
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("No Driver");
            e.printStackTrace();
        }
        Connection connection = null;
        try{
            connection = getConnection(CONNECTION, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("No connection");
            e.printStackTrace();
        }
        return connection;
    }

}
