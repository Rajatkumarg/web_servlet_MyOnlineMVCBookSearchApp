<%-- 
    Document   : nobooks
    Created on : 8 Aug, 2020, 2:42:38 PM
    Author     : Rajat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>book not found</title>
    </head>
    <body>
        No books of subject <span style="color:red; font-size:40px"><%= request.getAttribute("sub")%></span> is found
         
    </body>
</html>
