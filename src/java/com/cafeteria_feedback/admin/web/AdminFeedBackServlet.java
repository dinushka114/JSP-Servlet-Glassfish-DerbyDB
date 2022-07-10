/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cafeteria_feedback.admin.web;

import com.cafeteria_feedback.feedback.bean.Feedback;
import com.cafeteria_feedback.feedback.database.FeedbackDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/submitted-feedbacks")
public class AdminFeedBackServlet extends HttpServlet {
    private FeedbackDao feedbackDao;
    
    public void init(){
        feedbackDao = new FeedbackDao();
    }

    
  
    
    protected void getSelectedCategory(HttpServletRequest request, HttpServletResponse response ,String category) throws ServletException, IOException{
             List<Feedback> feedbacks = feedbackDao.getAllFeedbacksWithSelectedCategory(category);
              request.setAttribute("feedbacks", feedbacks);
              RequestDispatcher dispatcher = request.getRequestDispatcher("submitted-feedbacks.jsp");
              dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String category = request.getParameter("category");
        String deleteId = request.getParameter("deleteVal");

        if(category==null){
             List<Feedback> feedbacks = feedbackDao.getAllFeedbacks();
              request.setAttribute("feedbacks", feedbacks);
              RequestDispatcher dispatcher = request.getRequestDispatcher("submitted-feedbacks.jsp");
              dispatcher.forward(request, response);
        }
        else {
            getSelectedCategory(request , response , category);
        }
        
  
         
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
