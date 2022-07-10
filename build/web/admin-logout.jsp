<%-- 
    Document   : admin-logout
    Created on : 08-Jul-2022, 08:01:12
    Author     : Dinushka Piyumal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cafeteria Feedback Management</title>
    </head>
    <body>
        <%
            session.removeAttribute("username");
            response.sendRedirect("index.html");
        
        %>
    </body>
</html>
