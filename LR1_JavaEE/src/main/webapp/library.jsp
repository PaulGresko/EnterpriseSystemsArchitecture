<%@ page import="com.example.library.entities.Library" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Libraries</title></head>
<body>
<h1>Library Management</h1>

<h2>Add Library</h2>
<form action="libraries" method="post">
    <input type="text" name="name" placeholder="Library Name" required>
    <input type="text" name="address" placeholder="Library Address" required>
    <input type="hidden" name="action" value="add">
    <button type="submit">Add Library</button>
</form>

<h2>All Libraries</h2>
<ul>
    <%  List<Library> libraryList = (List<Library>) request.getAttribute("libraries");
        for (Library library : libraryList) {
    %>
    <li>
        <form action="libraries" method="post" style="display:inline;">
            ID: <%= library.getId() %>, Name: <%= library.getName() %>, Address: <%= library.getAddress() %>
            <input type="hidden" name="id" value="<%= library.getId() %>">
            <input type="hidden" name="action" value="delete">
            <button type="submit">Delete</button>
        </form>
    </li>
    <% } %>
</ul>

</body>
</html>
