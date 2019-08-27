<%@ page import="userpackage.Place" %>
<%@ page import="userpackage.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Place place = (Place) request.getAttribute("place");
    Comment[] comments = (Comment[]) request.getAttribute("comments");
%>
<html>
<head>
    <title>Detail</title>
</head>
<body>
    <h1><%= place.getName() %></h1>
    <p><%= place.getDistrict() %></p>
    <img src="<%= place.getImage() %>" alt="<%= place.getInformation() %>">
    <p><%= place.getInformation() %></p>

    <h3>Comments</h3>
    <hr>

    <% if (comments != null) {
        for (Comment comment : comments) { %>
            <div>
                <strong><%= comment.getUser().getUsername() %></strong>
            </div>
            <div>
                <p><%= comment.getContent() %></p>
            </div>
            <hr>
        <% }
    } %>
    <form action="/places/<%= place.getId() %>" method="post">
        <div>
            <textarea name="comment" cols="30" rows="10"></textarea>
        </div>
        <input type="submit">
    </form>
</body>
</html>
