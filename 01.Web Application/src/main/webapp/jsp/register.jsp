<%--
  Created by IntelliJ IDEA.
  User: fastrapier
  Date: 03.07.2021
  Time: 21:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
</center> <h1> Student Register Form </h1> </center>
<form name="register" action="/register" method="post">
    <div class="container">
        <label>Username : </label>
        <input type="text" placeholder="Enter Username" name="username" required>
        <label>Password : </label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <button type="submit">Register</button>
        <input type="checkbox" checked="checked"> Remember me
        <button type="button" class="cancelbtn"> Cancel</button>
        Forgot <a href="#"> password? </a>
    </div>
</form>
</body>
</html>
