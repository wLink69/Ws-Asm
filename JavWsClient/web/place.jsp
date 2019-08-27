<%@ page import="userpackage.Place" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Place[] places = (Place[]) request.getAttribute("places");
%>
<html>
<head>
    <title>Places</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <h1>Places</h1>
    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Image</th>
                <th scope="col">Information</th>
                <th scope="col">Action</th>
            </tr>
        </thead>

        <tbody>
            <% for (Place place : places) { %>
            <tr>
                <th scope="row"><%= place.getId() %></th>
                <td><a href="/places/<%= place.getId()%>"><%= place.getName() %></a></td>
                <td><img src="<%= place.getImage() %>" alt="" width="100px"></td>
                <td><%= place.getInformation() %></td>
                <td><a href="/place/update/<%= place.getId() %>">Edit</a> / <a href="/place/delete/<%= place.getId() %>">Delete</a></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
