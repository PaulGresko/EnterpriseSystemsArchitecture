<%@ page import="com.example.library.entities.Library" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.library.entities.Book" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Books</title></head>
<body>
<h1>Book Management</h1>

<h2>Add Book</h2>
<form action="books" method="post">
    <input type="text" name="title" placeholder="Book Title" required>
    <input type="text" name="description" placeholder="Book Description" required>
    <select name="library_id">
        <option disabled selected>Select Library</option>
        <%
            List<Library> libraryList = (List<Library>) request.getAttribute("libraries");
            for (Library library : libraryList) {
                %>
        <option value="<%= library.getId() %>"><%= library.getName() %></option>
        <% } %>
    </select>
    <input type="hidden" name="action" value="add">
    <button type="submit">Add Book</button>
</form>

<h2>All Books</h2>
<ul>
    <%
        List<Book> bookList =  (List<Book>) request.getAttribute("books");
        for (Book book : bookList) {
    %>
    <li>
        ID: <%= book.getId() %>, Title: <%= book.getTitle() %>, Description: <%= book.getDescription() %>, Library: <%= book.getLibrary().getName() %>
        <form action="books" method="post" style="display:inline;">
            <input type="hidden" name="id" value="<%= book.getId() %>">
            <input type="hidden" name="action" value="delete">
            <button type="submit">Delete</button>
        </form>
    </li>
    <% } %>
</ul>

</body>
</html>
