/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeteria_feedback.admin.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.cafeteria_feedback.admin.bean.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminDao {
    
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
    
    
    public boolean validate(Admin loginBean) throws ClassNotFoundException{
        boolean status = false;
            try(Connection connection = getConnection();
                    
                   PreparedStatement statement = connection.prepareStatement("select * from CAFE_OWNER where username = ? and password = ? ")){
                    statement.setString(1, loginBean.getUsername());
            statement.setString(2, loginBean.getPassword());
                         ResultSet resultSet = statement.executeQuery();
             status = resultSet.next();
            }catch(SQLException e){
                e.printStackTrace();
            }
            return status;
    }

    
    public Admin getValuesForUpdate(String uname){
            Admin admin = null;
             try(Connection connection = getConnection();
                    
                   PreparedStatement statement = connection.prepareStatement("select C.owner_id , C.owner_name , C.cafe_name ,C.phone ,  O.username , O.password from CAFE_OWNER_DETAILS C , CAFE_OWNER O where C.OWNER_ID = O.OWNER_ID and O.username = '"+uname+"' ")){
                    ResultSet resultSet = statement.executeQuery();
                    while(resultSet.next()){
                        String owner_id = resultSet.getString("owner_id");
                        String owner_name = resultSet.getString("owner_name");
                        String cafe_name = resultSet.getString("cafe_name");
                        String phone = resultSet.getString("phone");
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");
                        
                        admin = new Admin(owner_id , owner_name , cafe_name , phone , username , password);
                    }

            }catch(SQLException e){
                e.printStackTrace();
            }
            return admin;
    }

    public boolean updateAdmin(Admin adminBean){
        boolean status = false;
        
        try(Connection connection = getConnection();
                    
                   PreparedStatement statement = connection.prepareStatement("update cafe_owner_details set owner_name= ? , cafe_name = ? , phone = ? where owner_id = ?")){
                    statement.setString(1, adminBean.getOwnerName());
                    statement.setString(2, adminBean.getCafeName());
                    statement.setString(3, adminBean.getPhone());
                    statement.setString(4, adminBean.getOwnerId());
                    statement.execute();
                    
                    PreparedStatement statement1 = connection.prepareStatement("update cafe_owner set username = ? , password = ? where owner_id = ?");
                    statement1.setString(1, adminBean.getUsername());
                    statement1.setString(2, adminBean.getPassword());
                    statement1.setString(3, adminBean.getOwnerId());
                    statement1.execute();
                    status = true;

            }catch(SQLException e){
                e.printStackTrace();
            }

        
        return status;
    }

    private void printSQLException(SQLException e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
