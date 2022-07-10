/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria_feedback.student.bean;

import java.io.Serializable;

public class Student implements Serializable {
        
    private static final long serialVersionUID = 1L;
    private String student_name;
    private String student_id;
    
    public String getStudentId(){
        return student_id;
    }
    
    public String getStudentName(){
        return student_name;
    }
    
    public void setStudentName(String name){
        this.student_name = name;
    }
    
    public void setStudentId(String id){
        this.student_id = id;
    }
}
