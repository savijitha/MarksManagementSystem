package com.markPackage;

import java.sql.*;

public class ReportGenerator {

    public static void generateClassWiseReport(String department) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT s.name, c.course_name, m.marks_obtained, m.max_marks " +
                           "FROM Students s " +
                           "JOIN Marks m ON s.student_id = m.student_id " +
                           "JOIN Courses c ON m.course_id = c.course_id " +
                           "WHERE s.department = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, department);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Class-wise Report for Department: " + department);
            while (rs.next()) {
                String studentName = rs.getString("name");
                String courseName = rs.getString("course_name");
                int marksObtained = rs.getInt("marks_obtained");
                int maxMarks = rs.getInt("max_marks");
                System.out.printf("Student: %s, Course: %s, Marks: %d/%d%n", studentName, courseName, marksObtained, maxMarks);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void generateSubjectWiseReport(int courseId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT s.name, m.marks_obtained, m.max_marks " +
                           "FROM Marks m " +
                           "JOIN Students s ON m.student_id = s.student_id " +
                           "WHERE m.course_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Subject-wise Report for Course ID: " + courseId);
            while (rs.next()) {
                String studentName = rs.getString("name");
                int marksObtained = rs.getInt("marks_obtained");
                int maxMarks = rs.getInt("max_marks");
                System.out.printf("Student: %s, Marks: %d/%d%n", studentName, marksObtained, maxMarks);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void generateOverallPerformanceReport() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT s.name, AVG((m.marks_obtained / m.max_marks) * 100) AS avg_percentage " +
                           "FROM Students s " +
                           "JOIN Marks m ON s.student_id = m.student_id " +
                           "GROUP BY s.student_id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Overall Performance Report");
            while (rs.next()) {
                String studentName = rs.getString("name");
                double avgPercentage = rs.getDouble("avg_percentage");
                System.out.printf("Student: %s, Average Percentage: %.2f%%%n", studentName, avgPercentage);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void generateClassTopperReport(String department) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT s.name, SUM(m.marks_obtained) AS total_marks " +
                           "FROM Students s " +
                           "JOIN Marks m ON s.student_id = m.student_id " +
                           "WHERE s.department = ? " +
                           "GROUP BY s.student_id " +
                           "ORDER BY total_marks DESC " +
                           "LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, department);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Topper in Department: " + department);
            if (rs.next()) {
                String studentName = rs.getString("name");
                int totalMarks = rs.getInt("total_marks");
                System.out.printf("Student: %s, Total Marks: %d%n", studentName, totalMarks);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void generateOverallTopperReport() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT s.name, SUM(m.marks_obtained) AS total_marks " +
                           "FROM Students s " +
                           "JOIN Marks m ON s.student_id = m.student_id " +
                           "GROUP BY s.student_id " +
                           "ORDER BY total_marks DESC " +
                           "LIMIT 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Overall Topper Report");
            if (rs.next()) {
                String studentName = rs.getString("name");
                int totalMarks = rs.getInt("total_marks");
                System.out.printf("Student: %s, Total Marks: %d%n", studentName, totalMarks);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void generateClassRankedReport(String department) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT s.name, SUM(m.marks_obtained) AS total_marks " +
                           "FROM Students s " +
                           "JOIN Marks m ON s.student_id = m.student_id " +
                           "WHERE s.department = ? " +
                           "GROUP BY s.student_id " +
                           "ORDER BY total_marks DESC";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, department);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Ranked Report for Department: " + department);
            int rank = 1;
            while (rs.next()) {
                String studentName = rs.getString("name");
                int totalMarks = rs.getInt("total_marks");
                System.out.printf("Rank %d: Student: %s, Total Marks: %d%n", rank, studentName, totalMarks);
                rank++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void generateOverallRankedReport() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT s.name, SUM(m.marks_obtained) AS total_marks " +
                           "FROM Students s " +
                           "JOIN Marks m ON s.student_id = m.student_id " +
                           "GROUP BY s.student_id " +
                           "ORDER BY total_marks DESC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Overall Ranked Report");
            int rank = 1;
            while (rs.next()) {
                String studentName = rs.getString("name");
                int totalMarks = rs.getInt("total_marks");
                System.out.printf("Rank %d: Student: %s, Total Marks: %d%n", rank, studentName, totalMarks);
                rank++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
