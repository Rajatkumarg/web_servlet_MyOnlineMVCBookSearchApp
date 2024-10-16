<%-- 
    Document   : deletemsg
    Created on : 9 Aug, 2020, 8:54:14 AM
    Author     : Rajat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Page</title>
    </head>
    <body>
        Record of book <span style="color:green"><%= (String)request.getAttribute("bname")%></span> gets deleted
                
    </body>
</html>
