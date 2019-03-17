package Servlet;

import Bean.Account;
import Bean.User;
import Dao.AccountDao;
import Dao.PartyDao;
import Service.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/AccountAddServlet")
public class AccountAddServlet extends HttpServlet {
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
        int party_id = Integer.parseInt(request.getParameter("party_id"));
        int person_id = 0;
        for(User i: UserUtil.getUserListAll()){
            int user_id = i.getUser_id();
            String s = String.valueOf(user_id);
            if (request.getParameter(s) != null) {
                person_id = Integer.parseInt(request.getParameter(s));
            }
        }
        Account account = new Account(party_id, person_id, date);
        AccountDao.account_insert(account);
        PartyDao.party_update(party_id);
        request.getRequestDispatcher("index.jsp").forward(request, response);





    }
}
