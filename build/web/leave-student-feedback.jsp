<%-- 
    Document   : leave-student-feedback
    Created on : 09-Jul-2022, 19:11:00
    Author     : Dinushka Piyumal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Student feedback</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <style>
        
        h1 {
            text-align: center;
        }
        
        #feedback-form{
            width:24%;
            margin:auto;
        }
        
        #feedback-form #category-select{
            width:180px;
        }
        #feedback-form #feedback-text{
            margin-top:5px;
        }
        
        #feedback-form input[type="submit"]{
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
        <%
            
            if(session.getAttribute("student_id")==null || session.getAttribute("student_id")==" "){
                response.sendRedirect("student-personal-information.html");
            }
        

        %>
        <h1>Leave a Feedback</h1>
           
        <form id="feedback-form" action="new-feedback" method="post">
            
            <div>
                <label>Feedback category: </label>
            <select id="category-select" name="category">
                <option value="food" >food</option>
                <option value="price" >price</option>
                <option value="hygiene">hygiene</option>
                <option value="staff">staff</option>
            </select> 
            </div>
            <br>
            
            
            <div>
                 <label>Detailed Feedback </label> <br>
                 <textarea id="feedback-text" name="feedback" row="3" cols="45" ></textarea>
            </div>
            
            <br>
            
            <div>
                <label>overall ratings</label> 
            <input type="radio" name="rating" value="Excellent" /> Excellent
            <input type="radio" name="rating" value="Good" /> Good
            <input type="radio" name="rating" value="Bad" /> Bad
            
            </div>
            <br>
            
             <input type="submit" name="submit" value="Submit" />
        </form>
        
    </body>
</html>
