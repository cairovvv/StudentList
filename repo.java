package com.mycompany.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class repo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Connection string: 'jdbc:sqlite:' followed by the database file path
        String url = "jdbc:sqlite:Student.db";
        String sql = "SELECT * FROM tbl_students";

        // Use try-with-resources to ensure resources are closed automatically
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/james paul/Documents/Student.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("ID \tFirstName \t LastName \t Age \t Gender \t Yearlvl \t Course \t Bloodtype \t Address \t Contact");
            System.out.println("-----------------------------------------------------------------------------------------------");

            // Loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("studentID") +  "\t " + 
                                   rs.getString("FirstName") + "\t " +
                                   rs.getString("LastName") + "\t " +
                                   rs.getInt("Age") + "\t " +
                                   rs.getString("Gender") + "\t " +
                                   rs.getInt("Yearlvl") + "\t " +
                                   rs.getString("Course") + "\t " +
                                   rs.getString("Bloodtype") + "\t " +
                                   rs.getString("Address") + "\t " +
                                   rs.getInt("Contact"));
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    
    }
    
}
