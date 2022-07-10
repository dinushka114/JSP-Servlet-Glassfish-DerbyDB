/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria_feedback.feedback.database;

import com.cafeteria_feedback.feedback.bean.Feedback;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dinushka Piyumal
 */
public class FeedbackDao {
    
    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/cafeteria_db","root","root");
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        return connection;
    }
    
    public boolean saveFeedback(Feedback feedbackBean){
            boolean status = false;
            
            try(Connection connection = getConnection();
                    PreparedStatement statement = connection.prepareStatement("insert into FEEDBACK(student_id,feedback,category,rating) values(? , ? , ? , ?)")){
               
                    statement.setString(1, feedbackBean.getStudent_id());
                    statement.setString(2, feedbackBean.getFeedback());
                    statement.setString(3, feedbackBean.getCategory());
                    statement.setString(4, feedbackBean.getRating());
            
                    statement.execute();
                    status = true;
                }  catch(SQLException e){
                    e.printStackTrace();
            }
             return status;
    }
    
    public List<Feedback> getAllFeedbacks() {
        List<Feedback> feedbacks = new ArrayList<>(); 
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT S.student_name , S.student_id ,F.feedback_id, F.feedback , F.category , F.rating FROM FEEDBACK F , STUDENT S WHERE S.student_id=F.student_id");){
                       ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String student_name = resultSet.getString("student_name");
                String student_id = resultSet.getString("student_id");
                String category = resultSet.getString("category");
                String feedback =resultSet.getString("feedback");
                String rating = resultSet.getString("rating");
                String feedback_id = resultSet.getString("feedback_id");
                
                feedbacks.add(new Feedback(student_id , student_name , feedback , category , rating , feedback_id));
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
            }
        return feedbacks;
    }
    
    public List<Feedback> getAllFeedbacksWithSelectedCategory(String cat) {
        List<Feedback> feedbacks = new ArrayList<>(); 
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT S.student_name , S.student_id ,F.feedback_id, F.feedback , F.category , F.rating FROM FEEDBACK F , STUDENT S WHERE S.student_id=F.student_id and F.category= '"+cat+"'");){
                       ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String student_name = resultSet.getString("student_name");
                String student_id = resultSet.getString("student_id");
                String category = resultSet.getString("category");
                String feedback =resultSet.getString("feedback");
                String rating = resultSet.getString("rating");
                String feedback_id = resultSet.getString("feedback_id");
                
                feedbacks.add(new Feedback(student_id , student_name , feedback , category , rating , feedback_id));
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
            }
        return feedbacks;
    }
    
    public List<Feedback> getAllFeedbacksWithSelectedRating(String rate){
        List<Feedback> feedbacks = new ArrayList<>(); 
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT S.student_name , S.student_id ,F.feedback_id, F.feedback , F.category , F.rating FROM FEEDBACK F , STUDENT S WHERE S.student_id=F.student_id and F.rating= '"+rate+"'");){
                       ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String student_name = resultSet.getString("student_name");
                String student_id = resultSet.getString("student_id");
                String category = resultSet.getString("category");
                String feedback =resultSet.getString("feedback");
                String rating = resultSet.getString("rating");
                String feedback_id = resultSet.getString("feedback_id");
                
                feedbacks.add(new Feedback(student_id , student_name , feedback , category , rating , feedback_id));
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
            }
        return feedbacks;
    }
    
    
    public boolean deleteFeedback(String id) {
        boolean status = false;
        int f_id= 0;
        try{
            f_id = Integer.parseInt(id);
        }catch(Exception e){
            return status;
        }
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM FEEDBACK WHERE feedback_id="+f_id+" ");){
                       statement.executeUpdate();
                       status=true;
                       
            
        }catch(SQLException e){
            System.out.println(e);
            }
        
        return status;
    }
    
    
  
}
 
