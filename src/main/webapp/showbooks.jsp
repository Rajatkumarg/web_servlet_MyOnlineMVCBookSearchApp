<%-- 
    Document   : showbooks
    Created on : 8 Aug, 2020, 2:43:11 PM
    Author     : Rajat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>showing book</title>
    </head>
    <body>
        <h2>Book details are : </h2>
        Following are the books of the subject  <b><%= request.getAttribute("sub")%></b>
        <%
            out.println("<table border=2>");
            out.println("<tr><th>BookName</th><th>BookPrice</th></tr>");
            java.util.ArrayList<booksearch.mvc.Book> blist ; 
            blist = (java.util.ArrayList<booksearch.mvc.Book>)request.getAttribute("bookList");
            for(booksearch.mvc.Book b : blist){
                out.println("<tr><td>"+b.getBookname()+"</td><td>"+b.getBookprice()+"</td></tr>");
            }
        %>
    </body>
</html>
