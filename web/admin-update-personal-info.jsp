<%-- 
    Document   : update-personal-info
    Created on : 08-Jul-2022, 08:09:59
    Author     : Dinushka Piyumal
--%>
<%@page import="com.cafeteria_feedback.admin.bean.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        
        h1 {
            text-align: center;
        }
        
 
        #container {
    text-align: center;    
        }

        #container .form-container {
            display: inline-block;
        }

        #container form {
            display: flex;
            flex-direction: row;
            flex-wrap: nowrap;
            padding: 20px;
        }

        #container form .column {
            display: flex;
            flex-direction: column;
            flex-wrap: nowrap;

        }

        #container form .column label {
            padding: 2px;
            text-align: right;
            margin: 5px;
        }

        #container form .column input, 
        #container form .column textarea {
            align-self: flex-start;
            width: 200px;
            margin:5px;
        }
        
        #container form input[type="submit"] , a{
            margin-top: 20px;
            border-radius:50px;
            border:none;
            text-align: center;
            background-color: lightblue;
            padding:10px;
            display:block;
            width:180px;
            margin-left:auto;
            margin-right:auto;
            text-decoration: none;
            color:black;
        }
        
    </style>
    <body>
        <h1>Update Cafe Owner Information</h1>
         <%Admin personalData = 
            (Admin)request.getAttribute("admin");
        %>

            
             <div id="container">
            <div class="form-container">
                <form form action="update-cafeowner" method="post">
                    <div class="column">
                        <label for="text1">Owner Name: </label>
                        <label for="text2">Cafe Name: </label>
                        <label for="text2">Phone: </label>
                        <label for="text2">Username: </label>
                        <label for="text2">Password: </label>
 
                    </div>
                    <div class="column">
                         <input type="hidden" name="id" value="<%=personalData.getOwnerId()%>" />
                         <input type="text" name="owner_name" value="<%=personalData.getOwnerName()%>" />
                         <input type="text" name="cafe_name" value="<%=personalData.getCafeName()%>" />
                         <input type="text" name="phone" value="<%=personalData.getPhone()%>" />
                         <input type="text" name="username" value="<%=personalData.getUsername()%>" />
                          <input type="text" name="password" value="<%=personalData.getPassword()%>" />
                          <input type="submit" name="update" value="Update Information" />
                             <a href="admin-dashboard.jsp">Back to dashboard</a>
                    </div>
                    
                    
                </form>
            </div>
        </div>
        
    </body>
</html>
