/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cafeteria_feedback.student.web;

import com.cafeteria_feedback.student.bean.Student;
import com.cafeteria_feedback.student.database.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/student-validate")
public class StudentLoginServlet extends HttpServlet {
    
    private StudentDao studentDao; 

    @Override
    public void init(){
        studentDao = new StudentDao();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String student_name = request.getParameter("student_name");
           String student_id = request.getParameter("student_id");
           
           
           Student studentBean = new Student();
           
           studentBean.setStudentName(student_name);
           studentBean.setStudentId(student_id);
           
           try{
               if(studentDao.validateStudent(studentBean)){
                   HttpSession session = request.getSession();
                   session.setAttribute("student_id", student_id);
                   response.sendRedirect("student-validate-success.jsp");
               }else{
                    response.sendRedirect("student-validate-error.jsp");
               }
           }catch(IOException | ClassNotFoundException e){
                  response.sendRedirect("student-validate-error.jsp");
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
