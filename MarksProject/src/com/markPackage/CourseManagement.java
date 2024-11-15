package com.markPackage;
import java.sql.*;

public class CourseManagement {

    public static void addCourse(String courseCode, String courseName, int credits) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Courses (course_code, course_name, credits) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, courseCode);
            stmt.setString(2, courseName);
            stmt.setInt(3, credits);
            stmt.executeUpdate();
            System.out.println("Course added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCourse(int courseId, String newCourseName, int newCredits) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE Courses SET course_name = ?, credits = ? WHERE course_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newCourseName);
            stmt.setInt(2, newCredits);
            stmt.setInt(3, courseId);
            stmt.executeUpdate();
            System.out.println("Course updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteCourse(int courseId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Courses WHERE course_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, courseId);
            stmt.executeUpdate();
            System.out.println("Course deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
