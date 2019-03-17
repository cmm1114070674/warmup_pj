<%@ page import="Bean.Party" %>
<%@ page import="Service.PartyUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Service.AccountUtil" %>
<%@ page import="Service.UserUtil" %><%--
  Created by IntelliJ IDEA.
  User: 曹铭明
  Date: 2019/3/17
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  ArrayList<Party> parties = PartyUtil.getPartyListAll();
%>

<html>
  <head>
    <title>聚会信息</title>
  </head>
  <body>
  <center>
    <h1>聚会信息</h1>
    <br>
    <table border="1">
      <tr>
        <td>时间</td>
        <td>聚会名称</td>
        <td>聚会总费用</td>
        <td>聚会人员</td>
        <td>垫付人</td>
      </tr>

      <% for(Party i:parties){ %>
      <tr>
        <td><%=i.getDate()%></td>
        <td><%=i.getParty_name()%></td>
        <td><%=i.getFair()%></td>
        <td><%=PartyUtil.getPersonNames(i.getPersons())%></td>
        <% if(i.isBought()){ %>
        <td><%=AccountUtil.getPersonByPartyId(i.getParty_id())%></td>
        <% } %>
        <% if(!i.isBought()){ %>
        <td>
          <form action="account.jsp" method="get">
            <input type="hidden" name="party_id" value="<%= i.getParty_id()%>">
            <input type="submit" value="添加">
          </form>
        </td>
        <% } %>
      </tr>
      <% } %>
    </table>
    <br>
    <br>
    <form action="party.jsp" method="get">
      <input type="submit" value="添加新的聚会信息">
    </form>
    <br>

    <h2>
      总余额：<%= UserUtil.getSum()%>
    </h2>

  </center>
  </body>
</html>
