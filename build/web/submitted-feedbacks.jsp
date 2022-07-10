<%-- 
    Document   : submitted-feedbacks
    Created on : 08-Jul-2022, 18:49:52
    Author     : Dinushka Piyumal
--%>

<%@page import="com.cafeteria_feedback.feedback.bean.Feedback"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submitted Feedbacks</title>
    </head>
    
    <style>
        h1{
            text-align: center;
        }
        
        #category-select-form{
            text-align: center;
            margin:5px;
        }
        
        #bottom-form{
            text-align: center;
        }
        
         #bottom-form a{
            font-size: 14px;
        }
        
        #bottom-form input[type='submit'] , a{
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
        
        table{
            width: 75%;
            margin:auto;
        }
        
        table thead th{
            padding:20px;
            background:#9966ff;
 
        }
        
        table tbody td{
            padding:20px;
            background:#ccccff;
 
        }
        
    </style>
    
    <body>
        <h1>Submitted Feedbacks</h1>
        
        <form id="category-select-form" name="categoryForm" action="submitted-feedbacks" method="get">
            <label>Feedback category</label>
            <select name="category" onchange="javascript:document.categoryForm.submit();">
               <option selected="selected" value="">Select Category</option>
                <option value="food" >food</option>
                <option value="price" >price</option>
                <option value="hygiene">hygiene</option>
                <option value="staff">staff</option>
            </select>
            
            
        </form>
        
        <table>
            
            <thead>
                <th>Name</th>
                <th>Student ID</th>
                <th>Feedback category</th>
                <th>Detailed feedback</th>
                <th>Rating</th>
                <th>Delete</th>
            </thead>
            
            <tbody>
                <%ArrayList<Feedback> feedbacks = 
            (ArrayList<Feedback>)request.getAttribute("feedbacks");
        for(Feedback s:feedbacks){%>
        <tr>
            <td><%=s.getStudentName()%></td>
            <td><%=s.getStudent_id()%></td>
            <td><%=s.getCategory()%></td>
            <td><%=s.getFeedback()%></td>
            <td><%=s.getRating()%></td>
            <td> <input type="radio" name="delete" onClick="setValueTextBox(<%=s.getFeedback_id()%>)" value="<%=s.getFeedback_id()%>" /> </td>
        </tr> 
            <%}%>    
            </tbody>
            
        </table>
            
            <div id="bottom-form">
                <form action="delete-feedback" method="get">
                    <input type="hidden" name="deleteVal" id="delVal" />
                    <input type="submit" name="delete" value="delete" />
            </form>
            
            <a href="admin-dashboard.jsp">Back to Dashboard</a>
            </div>
            <script>
               
                function setValueTextBox(id){
                    document.getElementById("delVal").value=id;
                }
            </script>
    </body>
</html>
