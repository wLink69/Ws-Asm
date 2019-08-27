<%@ page import="userpackage.Place" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Place place = (Place) request.getAttribute("place");
%>
<html>
<head>
    <title>Update Place</title>
</head>
<body>
<h1>Create Place</h1>
<form action="/place/update/<%= place.getId() %>" method="post">
    <div>
        Name <input type="text" name="name" value="<%= place.getName() %>">
    </div>
    <div>
        District <input type="text" name="district" value="<%= place.getDistrict() %>">
    </div>
    <div>
        Image <input type="text" name="image" value="<%= place.getImage() %>">
    </div>
    <div>
        Information <input type="text" name="information" value="<%= place.getInformation() %>">
    </div>
    <div>
        <input type="submit">
    </div>
</form>
</body>
</html>
