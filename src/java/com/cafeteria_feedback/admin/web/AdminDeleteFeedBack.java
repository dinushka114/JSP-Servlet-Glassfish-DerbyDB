/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cafeteria_feedback.admin.web;

import com.cafeteria_feedback.feedback.database.FeedbackDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dinushka Piyumal
 */
@WebServlet("/delete-feedback")
public class AdminDeleteFeedBack extends HttpServlet {
    
    private FeedbackDao feedbackDao;
    
    public void init(){
        feedbackDao = new FeedbackDao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
        }
    }

    protected void deleteSelectedRating(HttpServletRequest request, HttpServletResponse response ,String deleteId) throws IOException{
        boolean isDeleted = feedbackDao.deleteFeedback(deleteId);
        if(isDeleted){
            response.sendRedirect("rating-deleted.jsp");
        }else{
             response.sendRedirect("rating-delete-failed.jsp");
        }
    }
    
      protected void deleteSelectedFeedback(HttpServletRequest request, HttpServletResponse response ,String id) throws IOException, ServletException{
        boolean isDeleted = feedbackDao.deleteFeedback(id);
        if(isDeleted) {
            response.sendRedirect("feedback-deleted.jsp");
        }else{
            response.sendRedirect("feedback-delete-failed.jsp");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String deleteId = request.getParameter("deleteVal");
       if(deleteId!=null){
           deleteSelectedFeedback(request , response , deleteId);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String deleteId = request.getParameter("deleteVal");
       if(deleteId!=null){
           deleteSelectedRating(request , response , deleteId);
       }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
