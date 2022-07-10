/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria_feedback.student.database;

import com.cafeteria_feedback.student.bean.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Dinushka Piyumal
 */
public class StudentDao {
    public boolean validateStudent(Student studentBean) throws ClassNotFoundException{
         boolean status = false;
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        try{
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/cafeteria_db","root","root");
            PreparedStatement statement = connection.prepareStatement("select * from STUDENT where student_name = ? and student_id = ? ");
            statement.setString(1, studentBean.getStudentName());
            statement.setString(2, studentBean.getStudentId());
                    
             ResultSet resultSet = statement.executeQuery();
             status = resultSet.next();
            
        }catch(Exception e){
            System.out.println(e);
        }
        return status;
    }
}
