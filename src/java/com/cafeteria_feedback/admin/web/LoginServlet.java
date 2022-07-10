/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cafeteria_feedback.admin.web;

import com.cafeteria_feedback.admin.bean.Admin;
import com.cafeteria_feedback.admin.database.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/admin-login")
public class LoginServlet extends HttpServlet {
    
     private static final long serialVersionUID = 1L;
     private AdminDao adminLoginDao;
     
     @Override
     public void init(){
         adminLoginDao = new AdminDao();
     }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String username = request.getParameter("username");
           String password = request.getParameter("password");
           
           
           Admin adminLoginBean = new Admin();
           
           adminLoginBean.setUsername(username);
           adminLoginBean.setPassword(password);
           
           
           
           try{
               if(adminLoginDao.validate(adminLoginBean)){
                   HttpSession session = request.getSession();
                   session.setAttribute("username", username);
                   session.setAttribute("owner_id",adminLoginBean.getOwnerId());
                   System.out.println(adminLoginBean.getOwnerId());
                   response.sendRedirect("admin-dashboard.jsp");
               }else{
                    response.sendRedirect("admin-login-error.jsp");
               }
           }catch(IOException | ClassNotFoundException e){
                  response.sendRedirect("admin-login-error.jsp");
           }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
