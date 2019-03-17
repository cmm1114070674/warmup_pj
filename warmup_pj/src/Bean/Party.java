package Bean;

import java.util.ArrayList;
import java.util.Date;

public class Party {
    private int party_id;
    private Date date;
    private String party_name;
    private int person_number;
    private int fair;
    private ArrayList<Integer> persons;
    private boolean isBought = false;

    public Party(int party_id, Date date, String party_name, int person_number, int fair, ArrayList<Integer> persons, boolean isBought){
        this.party_id = party_id;
        this.date = date;
        this.party_name = party_name;
        this.person_number = person_number;
        this.fair = fair;
        this.isBought = isBought;
        this.persons = persons;
    }

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPerson_number() {
        return person_number;
    }

    public void setPerson_number(int person_number) {
        this.person_number = person_number;
    }

    public int getFair() {
        return fair;
    }

    public void setFair(int fair) {
        this.fair = fair;
    }

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public ArrayList<Integer> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Integer> persons) {
        this.persons = persons;
    }


}
