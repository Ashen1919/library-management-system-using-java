/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class dbConn {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/lms";
        String username = "root";
        String password = "";
        
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected to database");
            
            conn.close();
        }
        catch(SQLException e){
            System.out.println("Connection failed " + e.getMessage());
        }
    }
}
