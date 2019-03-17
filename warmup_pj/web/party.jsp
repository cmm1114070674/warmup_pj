<%@ page import="Bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Service.UserUtil" %><%--
  Created by IntelliJ IDEA.
  User: 曹铭明
  Date: 2019/3/17
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<User> users = UserUtil.getUserListAll();
%>


<html>
<head>
    <title>聚会添加</title>
</head>
<body>
<center>
    <h1>聚会添加</h1>
    <br>
    <form action="PartyAddServlet" method="get">
        <p>年</p>
        <input type="text" name = "year" value="">
        <p>月</p>
        <input type="text" name = "month" value="">
        <p>日</p>
        <input type="text" name = "day" value="">
        <p>聚会名称</p>
        <input type="text" name = "party_name" value="">
        <br>
        <p>聚会费用</p>
        <input type="text" name = "fair" value="">
        <br>
        <p>聚会人员</p>
        <% for(User i:users){ %>
        <p><input type="checkbox" name="<%=i.getUser_id()%>" value="<%=i.getUser_id()%>" /><%=i.getUsername()%></p>
        <% } %>
        <br>
        <input type="submit" value="添加">
    </form>
    <form action="index.jsp">
        <input type="submit" value="返回">
    </form>
</center>
</body>
</html>
