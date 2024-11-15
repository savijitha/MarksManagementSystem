package com.markPackage;
import java.sql.*;

public class UserAuthentication {

	public static boolean authenticateUser(String username, String hashedPassword) {
	    try (Connection conn = DatabaseConnection.getConnection()) {
	        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
	        PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setString(1, username);
	        stmt.setString(2, hashedPassword);
	        
	        ResultSet rs = stmt.executeQuery();
	        return rs.next(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

    public static String getUserRole(String username) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT role FROM Users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getUserId(String username) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT user_id FROM Users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("user_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; 
    }
    
    public static int getStudentIdByUsername(String username) {
        try (Connection conn = DatabaseConnection.getConnection()) {
           
            String query = "SELECT s.student_id " +
                           "FROM Students s " +
                           "JOIN Users u ON s.user_id = u.user_id " +
                           "WHERE u.username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("student_id");
            } else {
                System.out.println("No student record found for username: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; 
    }


    
}
