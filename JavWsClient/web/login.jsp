<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/26/2019
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="/login" method="post">
        <div>
            <input type="text" name="username">
        </div>
        <div>
            <input type="password" name="password">
        </div>
        <div>
            <input type="submit">
        </div>
    </form>
</body>
</html>
