package Servlet;

import Bean.Party;
import Bean.User;
import Dao.PartyDao;
import Dao.PartyPersonDao;
import Dao.UserDao;
import Service.PartyUtil;
import Service.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/PartyAddServlet")
public class PartyAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf8");
        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));
        int day = Integer.parseInt(request.getParameter("day"));
        String s_date = month+"/"+day+"/"+year;
        Date date = new Date(s_date);
        String party_name = request.getParameter("party_name");
        int fair = Integer.parseInt(request.getParameter("fair"));
        ArrayList<Integer> persons = new ArrayList<>();
        for(User i: UserUtil.getUserListAll()){
            int user_id = i.getUser_id();
            String s = String.valueOf(user_id);
            if (request.getParameter(s) != null) {
                int id = Integer.parseInt(request.getParameter(s));
                persons.add(id);
            }
        }
        int number = persons.size();
        Party party = new Party(0, date, party_name, number, fair, persons, false);
        PartyDao.party_insert(party);
        int party_id = 0;
        for(Party j:PartyUtil.getPartyListAll()){
            if(j.getParty_name().equals(party_name) && j.getPerson_number()==number)
                party_id = j.getParty_id();
        }
        party.setParty_id(party_id);
        PartyPersonDao.party_insert(party);
        int cost = fair / number;
        int cost0 = fair - fair / number * (number - 1);
        for(int i:persons){
            UserDao.person_update(i, UserUtil.getUserById(i).getMoney() - cost);
        }
        int first = persons.get(0);
        UserDao.person_update(first, UserUtil.getUserById(first).getMoney() + cost - cost0);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
