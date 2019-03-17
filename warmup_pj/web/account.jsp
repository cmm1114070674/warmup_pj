<%@ page import="Bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Service.UserUtil" %><%--
  Created by IntelliJ IDEA.
  User: 曹铭明
  Date: 2019/3/17
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int party_id = 0;
    ArrayList<User> users = UserUtil.getUserListAll();
    if (request.getParameter("party_id") != null){
        party_id = Integer.parseInt(request.getParameter("party_id"));
    }
%>


<html>
<head>
    <title>垫付添加</title>
</head>
<body>
<center>
    <h1>垫付添加</h1>
    <br>
    <form action="AccountAddServlet" method="get">
        <p>年</p>
        <input type="text" name = "year" value="">
        <p>月</p>
        <input type="text" name = "month" value="">
        <p>日</p>
        <input type="text" name = "day" value="">
        <p>垫付人</p>
        <% for(User i:users){ %>
        <p><input type="checkbox" name="<%=i.getUser_id()%>" value="<%=i.getUser_id()%>" /><%=i.getUsername()%></p>
        <% } %>
        <br>
        <input type="hidden" name="party_id" value="<%=party_id%>">
        <input type="submit" value="添加">
    </form>
    <form action="index.jsp">
        <input type="submit" value="返回">
    </form>
</center>
</body>
</html>
