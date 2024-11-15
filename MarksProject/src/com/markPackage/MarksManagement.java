package com.markPackage;

import java.sql.*;

public class MarksManagement {

    public static void addOrUpdateMarks(int studentId, int courseId, int marksObtained, int maxMarks) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Marks (student_id, course_id, marks_obtained, max_marks) " +
                           "VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE marks_obtained = ?, max_marks = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.setInt(3, marksObtained);
            stmt.setInt(4, maxMarks);
            stmt.setInt(5, marksObtained);
            stmt.setInt(6, maxMarks);
            stmt.executeUpdate();
            System.out.println("Marks added/updated successfully.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
