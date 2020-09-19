/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Saidur Rahman Akash
 */
public class DBConnection {
    
    
public  static Connection getConnection() throws SQLException {
    
    Connection conn=null;    
    
    try{
    conn =  DriverManager.getConnection("jdbc:mysql://localhost/Customer_Service","root","");
    
    if(conn != null){
    System.out.println("Connected Successfully");
    
    }
    else{
      System.out.println("Failed to Connect");
    }
    }
    catch(Exception e){
    
        System.err.println(e);
        
    }
    return conn;
    }
}
