/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cafeteria_feedback.admin.web;

import com.cafeteria_feedback.admin.bean.Admin;
import com.cafeteria_feedback.admin.database.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/update-cafeowner")
public class AdminPersonalDataServlet extends HttpServlet {
    
    private AdminDao adminDao;
    
    public void init(){
        adminDao = new AdminDao();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
            String username =(String) session.getAttribute("username");
            Admin adminPersonalData = adminDao.getValuesForUpdate(username);
            request.setAttribute("admin", adminPersonalData);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin-update-personal-info.jsp");
            dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String owner_name = request.getParameter("owner_name");
        String cafe_name = request.getParameter("cafe_name");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Admin admin = new Admin(id , owner_name , cafe_name , phone , username , password);
        
   
        
        if(admin.validateAdminInformations()){
            response.sendRedirect("admin-update-invalid.jsp");
        }
        else if( adminDao.updateAdmin(admin)){
           response.sendRedirect("admin-update-success.jsp");
       }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
