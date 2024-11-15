package com.markPackage;

import java.sql.*;

public class MarksViewing {

	
	public static void viewMarks(int studentId) {
	    String query = "SELECT c.course_name, m.marks_obtained, m.max_marks " +
	                   "FROM Marks m " +
	                   "JOIN Courses c ON m.course_id = c.course_id " +
	                   "WHERE m.student_id = ?";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        
	        stmt.setInt(1, studentId); 
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            String courseName = rs.getString("course_name");
	            int marksObtained = rs.getInt("marks_obtained");
	            int maxMarks = rs.getInt("max_marks");
	            System.out.println("Course: " + courseName + ", Marks: " + marksObtained + "/" + maxMarks);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

    
    public static void viewAllStudentsInCourse(int courseId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT Courses.course_name AS course_name, Students.name AS student_name, " +
                           "Marks.marks_obtained, Marks.max_marks " +
                           "FROM Marks " +
                           "JOIN Students ON Marks.student_id = Students.student_id " +
                           "JOIN Courses ON Marks.course_id = Courses.course_id " +
                           "WHERE Marks.course_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, courseId);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String courseName = rs.getString("course_name");
                System.out.println("Course: " + courseName + " (Course ID: " + courseId + ")");
                System.out.println("Marks:");
                
                do {
                    String studentName = rs.getString("student_name");
                    int marksObtained = rs.getInt("marks_obtained");
                    int maxMarks = rs.getInt("max_marks");
                    System.out.println("Student: " + studentName + ", Marks: " + marksObtained + "/" + maxMarks);
                } while (rs.next());
            } else {
                System.out.println("No students found for Course ID: " + courseId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void viewMarksInCourse(int studentId, int courseId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT Courses.course_name, Marks.marks_obtained, Marks.max_marks " +
                           "FROM Marks JOIN Courses ON Marks.course_id = Courses.course_id " +
                           "WHERE Marks.student_id = ? AND Marks.course_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String courseName = rs.getString("course_name");
                int marksObtained = rs.getInt("marks_obtained");
                int maxMarks = rs.getInt("max_marks");
                System.out.println("Course: " + courseName + ", Marks: " + marksObtained + "/" + maxMarks);
            } else {
                System.out.println("No marks found for the specified course and student ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void viewSingleStudentMarkInCourse(int studentId, int courseId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT Courses.course_name, Marks.marks_obtained, Marks.max_marks " +
                           "FROM Marks JOIN Courses ON Marks.course_id = Courses.course_id " +
                           "WHERE Marks.student_id = ? AND Marks.course_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String courseName = rs.getString("course_name");
                int marksObtained = rs.getInt("marks_obtained");
                int maxMarks = rs.getInt("max_marks");
                System.out.println("Student ID: " + studentId);
                System.out.println("Course: " + courseName + ", Marks: " + marksObtained + "/" + maxMarks);
            } else {
                System.out.println("No marks found for Student ID: " + studentId + " in Course ID: " + courseId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
