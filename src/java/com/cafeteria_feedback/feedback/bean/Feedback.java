/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria_feedback.feedback.bean;

/**
 *
 * @author Dinushka Piyumal
 */

import java.io.Serializable;

public class Feedback implements Serializable{
    private static long serialVersionUID = 1L;
    
  
    private String student_id;
    private String student_name;
    private String feedback;
    private String feedback_id;
    private String category;
    private String rating;

    
    public Feedback(String id , String name , String feedback , String category , String rating ,String feedback_id){
        this.student_id = id;
        this.student_name = name;
        this.feedback = feedback;
        this.category = category;
        this.rating = rating;
        this.feedback_id = feedback_id;
    }
    
 
   
    public Feedback(){

    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the student_id
     */
    public String getStudent_id() {
        return student_id;
    }

    /**
     * @param student_id the student_id to set
     */
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    /**
     * @return the feedback
     */
    public String getFeedback() {
        return feedback;
    }
    
    public String getStudentName(){
        return student_name;
    }

    /**
     * @param feedback the feedback to set
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public String getFeedback_id(){
        return feedback_id;
    }
    
    public boolean validateFeedback(){
        boolean isInvalid = false;
        
        if(this.student_id.trim().equals("") || this.feedback.trim().equals("")||this.category.trim().equals("")||this.rating.trim().equals("")){
            isInvalid = true;
        }
        
        return isInvalid;
    }
    
}
