/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice_page;
/**
 *
 * @author Asus
 */
public class Statement {
    public Statement(){
        
    }
    
    public int executeUpdate(String sql) {
        // Here you would typically have code that interacts with a database.
        // For demonstration, we'll just print the SQL statement and return a mock result.
        System.out.println("Executing SQL: " + sql);
        
        // Simulate the number of rows affected (mock return value)
        int rowsAffected = 1; // Replace with actual database interaction logic
        
        return rowsAffected;
    }

    void execute(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
