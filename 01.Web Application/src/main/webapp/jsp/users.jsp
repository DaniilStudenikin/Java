<%@ page import="ru.itis.javalab.models.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: fastrapier
  Date: 03.07.2021
  Time: 19:40
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1 style="color: ${cookie.get("color").value}">USERS</h1>
<form action="/users" method="post">
  <select name="color">
    <option value="red">RED</option>
    <option value="green">GREEN</option>
    <option value="blue">BLUE</option>
  </select>
  <input type="submit" value="OK">
</form>
<table>
  <th>ID</th>
  <th>FIRST_NAME</th>
  <th>LAST_NAME</th>
  <th>AGE</th>
  <%
    List<User> users = (List<User>) request.getAttribute("usersForJsp");
    for (int i = 0; i < users.size(); i++) {
  %>
  <tr>
    <td><%=users.get(i).getId()%>
    </td>
    <td><%=users.get(i).getUsername()%>
    </td>
    <td><%=users.get(i).getPassword()%>
  </tr>
  <%
    }
  %>
</table>
</body>
<head>
  <title>Title</title>
</head>
</html>
