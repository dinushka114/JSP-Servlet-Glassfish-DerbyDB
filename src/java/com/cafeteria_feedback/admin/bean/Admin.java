/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria_feedback.admin.bean;
import java.io.Serializable;

public class Admin implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String owner_id;
    private String owner_name;
    private String cafe_name;
    private String phone;
    private String username;
    private String password;
    
    public Admin(String owner_id ,String owner_name ,String cafe_name ,String phone ,String username ,String password){
        this.owner_id = owner_id;
        this.owner_name = owner_name;
        this.cafe_name = cafe_name;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }
    
    public Admin(){
    }
    
    public String getOwnerId(){
        return owner_id;
    }
    
    public String getOwnerName(){
        return owner_name;
    }
    
    public String getCafeName(){
        return cafe_name;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setOwnerName(String ownerName){
        this.owner_name = ownerName;
    }
    
    public void setCafename(String cafeName){
        this.cafe_name = cafeName;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public boolean validateAdminInformations(){
        boolean isInValid = false;
        
        if(this.owner_name.trim().equals("")|| this.cafe_name.trim().equals("")|| this.username.trim().equals("") || this.password.trim().equals("") ){
            isInValid = true;
        }
        
        if(this.phone.length()>10 || this.phone.trim().equals("")){
            isInValid = true;
        }
        
        return isInValid;
    }
    
}
