package Bean;

import java.util.Date;

public class Account {
    private int party_id;
    private int user_id;
    private Date date;

    public Account(int party_id, int user_id, Date date){
        this.party_id = party_id;
        this.date = date;
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
