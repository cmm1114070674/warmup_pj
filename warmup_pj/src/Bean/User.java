package Bean;

import java.util.Date;

public class User {
    private int user_id;
    private String username;
    private int money;

    public User(int user_id, String username, int money){
        this.user_id = user_id;
        this.username = username;
        this.money = money;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
