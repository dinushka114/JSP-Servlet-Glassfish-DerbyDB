/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cafeteria_feedback.admin.web;

import com.cafeteria_feedback.feedback.bean.Feedback;
import com.cafeteria_feedback.feedback.database.FeedbackDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submitted-ratings")
public class AdminRatingServlet extends HttpServlet {
    
     private FeedbackDao feedbackDao;
    
    public void init(){
        feedbackDao = new FeedbackDao();
    }

 

     protected void getSelectedRating(HttpServletRequest request, HttpServletResponse response ,String rating) throws ServletException, IOException{
             List<Feedback> feedbacks = feedbackDao.getAllFeedbacksWithSelectedRating(rating);
              request.setAttribute("feedbacks", feedbacks);
              RequestDispatcher dispatcher = request.getRequestDispatcher("submitted-ratings.jsp");
              dispatcher.forward(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String rating = request.getParameter("rating");
           String deleteId = request.getParameter("deleteVal");

        if(rating==null){
             List<Feedback> feedbacks = feedbackDao.getAllFeedbacks();
              request.setAttribute("feedbacks", feedbacks);
              RequestDispatcher dispatcher = request.getRequestDispatcher("submitted-ratings.jsp");
              dispatcher.forward(request, response);
            }else{
            getSelectedRating(request , response , rating);
         }
   
        }
        
         
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
