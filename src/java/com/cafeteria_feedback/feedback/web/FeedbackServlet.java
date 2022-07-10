/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cafeteria_feedback.feedback.web;

import com.cafeteria_feedback.feedback.bean.Feedback;
import com.cafeteria_feedback.feedback.database.FeedbackDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dinushka Piyumal
 */
@WebServlet("/new-feedback")
public class FeedbackServlet extends HttpServlet {
    
    private FeedbackDao feedbackDao;
    
    @Override
    public void init(){
           feedbackDao = new FeedbackDao();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String student_id = (String) session.getAttribute("student_id");
            String feedback = request.getParameter("feedback");
            String category = request.getParameter("category");
            String rating = request.getParameter("rating");
            
            Feedback feedbackBean = new Feedback(); 
            feedbackBean.setStudent_id(student_id);
            feedbackBean.setRating(rating);
            feedbackBean.setFeedback(feedback);
            feedbackBean.setCategory(category);
            
            try{
               if(feedbackBean.validateFeedback()){
                   response.sendRedirect("feedback-error.jsp");
               }
                else if(feedbackDao.saveFeedback(feedbackBean)){
                    response.sendRedirect("feedback-success.jsp");
                }
            }catch(Exception e){
                 response.sendRedirect("feedback-error.jsp");

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
            throws ServletException, IOException  {
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
