<%--
  Created by IntelliJ IDEA.
  User: wLink
  Date: 8/26/2019
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Place</title>
</head>
<body>
<h1>Create Place</h1>
<form action="/place/create" method="post">
    <div>
        Name <input type="text" name="name">
    </div>
    <div>
        District <input type="text" name="district">
    </div>
    <div>
        Image <input type="text" name="image">
    </div>
    <div>
        Information <input type="text" name="information">
    </div>
    <div>
        <input type="submit">
    </div>
</form>
</body>
</html>
