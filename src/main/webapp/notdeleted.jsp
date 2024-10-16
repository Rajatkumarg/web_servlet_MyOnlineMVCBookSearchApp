<%-- 
    Document   : deleteerrormsg
    Created on : 9 Aug, 2020, 8:56:42 AM
    Author     : Rajat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>not deleted Page</title>
    </head>
    <body>
        <h2 style="color:red"> Record of book <%= (String)request.getAttribute("bname")%> is not found</h2>
    </body>
</html>
