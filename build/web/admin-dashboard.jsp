<%-- 
    Document   : admin-dashboard
    Created on : 08-Jul-2022, 06:36:55
    Author     : Dinushka Piyumal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/admin_dashboard.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            if(session.getAttribute("username")==null || session.getAttribute("username")==" "){
                response.sendRedirect("admin-login-error.jsp");
            }
        

        %>
        
        <h1 id="admin_dashboard_title">Dashboard</h1>
        
        <div id="admin_navigation_buttons">
               
            <a href="submitted-feedbacks">Submitted Feedbacks</a>
            <a href="submitted-ratings">Ratings</a>
            <a href="update-cafeowner">Update Personal Info</a>
            
        </div>
        
        <a href="admin-logout.jsp" id="logout_admin">Logout</a>
        
 
    </body>
</html>
