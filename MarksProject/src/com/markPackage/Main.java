package com.markPackage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        int count=0;

        if (UserAuthentication.authenticateUser(username, password)) {
            String role = UserAuthentication.getUserRole(username);
            System.out.println("Logged in as: " + role);

            switch (role) {
                case "admin":

                    do {
                    
                    System.out.println("...Admin options...");
                    System.out.println("1.Add Courses ");
                    System.out.println("2. Delete Course ");
                    System.out.println("3. Update Course ");
                    System.out.println("4. View Marks ");
                    System.out.println("5. Show report");
                    System.out.println("6. Log out");
                    System.out.println("Enter your choice :");
                    
                    int choice=scanner.nextInt();
                    scanner.nextLine();
                    
                    switch(choice) {
                    
                    case 1:
                        System.out.println("Enter the Course Name :");
                        String name=scanner.nextLine();
                        System.out.println("Enter the Course Code :");
                        String code=scanner.nextLine();
                        System.out.println("Enter your credits :");
                        int credits=scanner.nextInt();
                        CourseManagement.addCourse(code, name, credits);
                        break;
                        
                    case 2 :
                        System.out.println("Enter Course id to delete :");
                        int id=scanner.nextInt();
                        CourseManagement.deleteCourse(id);
                        break;
                        
                    case 3 :
                        System.out.println("Enter the Course id:");
                        int id2=scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the New Course Name :");
                        String newName=scanner.nextLine();
                        System.out.println("Enter the New Credits :");
                        int credits2=scanner.nextInt();
                        CourseManagement.updateCourse(id2, newName, credits2);
                        break;
                        
                    case 4:
                        int count2=0;
                        do {
                        System.out.println("1. view particular student's all course's marks");
                        System.out.println("2. view a particular course's all marks");
                        System.out.println("3. view a particular student mark in a particular course");
                        System.out.println("4. exit");
                        int choice4=scanner.nextInt();
                        scanner.nextLine();
                        
                        switch(choice4) {
                        
                        case 1:
                            System.out.println("Enter Student id to view his/her marks :");
                            int id3=scanner.nextInt();
                            MarksViewing.viewMarks(id3);
                            break;
                            
                        case 2 :
                            System.out.println("Enter the course id :");
                            int course_id=scanner.nextInt();
                            MarksViewing.viewAllStudentsInCourse(course_id);
                            break;
                            
                        case 3 :
                            System.out.println("Enter the Student id :");
                            int stud_id=scanner.nextInt();
                            System.out.println("Enter the course id :");
                            int c_id=scanner.nextInt();
                            MarksViewing.viewSingleStudentMarkInCourse(stud_id, c_id);
                            break;
                            
                        case 4:
                            System.out.println("******Exited******");
                            count2=1;
                            break;
                        
                        default:
                            System.out.println("Invalid choice !!!");
                            break;
                            
                        }
                        } while(count2!=1);
                        break;
                        
                    case 5:
                    	int count5=0;
                    	do {
                    	System.out.println("1. GenerateClassWiseReport");
                    	System.out.println("2. GenerateSubjectWiseReport");
                    	System.out.println("3. GenerateOverallPerformanceReport");
                    	System.out.println("4. Topper Reports");
                    	System.out.println("5. Exit");
                    	System.out.println("Enter your choice :");
                    	int choice2=scanner.nextInt();
                    	scanner.nextLine();
                    		switch(choice2) {
                    		case 1 :
                    			System.out.println("Enter the Department :");
                    			String dep=scanner.nextLine();
                    			ReportGenerator.generateClassWiseReport(dep);
                    			break;
                    		case 2:
                    			System.out.println("Enter the course Id :");
                    			int c_id=scanner.nextInt();
                    			ReportGenerator.generateSubjectWiseReport(c_id);
                    			break;
                    		case 3:
                    			ReportGenerator.generateOverallPerformanceReport();
                    			break;
                    		case 4:
                    			int count6=0;
                    			do {
                    			System.out.println("1. Get the topper in a particular class for all courses.");
                    			System.out.println("2. Get the overall topper across all classes and courses.");
                    			System.out.println("3. Generate a report ordered from topper to lowest marks within a class");
                    			System.out.println("4. Generate a report ordered from topper to lowest marks across all classes.");
                    			System.out.println("5. Exit");
                    			
                    			System.out.println("Enter your choice");
                    			int choice5=scanner.nextInt();
                    			scanner.nextLine();
                    			switch(choice5) {
                    			case 1:
                    				System.out.println("Enter the department :");
                    				String dep1=scanner.nextLine();
                    				ReportGenerator.generateClassTopperReport(dep1);
                    				break;
                    			case 2:
                    				ReportGenerator.generateOverallTopperReport();
                    				break;
                    			case 3:
                    				System.out.println("Enter the department :");
                    				String dep2=scanner.nextLine();
                    				ReportGenerator.generateClassRankedReport(dep2);
                    				break;
                    			case 4:
                    				ReportGenerator.generateOverallRankedReport();
                    				break;
                    			case 5:
                    				System.out.println("******Exited******");
                    				count6=1;
                    				break;
                    			default:
                    			System.out.println("Invalid choice!!!");
                    			break;
                    			}
                    			}while(count6!=1);
                    			break;
                    		case 5 :
                    			System.out.println("******Exited******");
                    			count5=1;
                    			break;
                    		default:
                    			System.out.println("Invalid choice!!!");
                    			break;
                    		}
                    	}while(count5!=1);
                    	break;
                        
                    case 6:
                        System.out.println("---- Logged out ----");
                        count=1;
                        break;
    
                    default :
                            System.out.println("Invalid Choice");
                            break;
                            
                    }
                    } while(count!=1);
                    
                    break;
                    
                case "professor":
                    int count1=0;
                    do {
                    
                    System.out.println("Professor options...");
                    System.out.println("1. Add/Update marks ");
                    System.out.println("2. View marks ");
                    System.out.println("3. View Reports");
                    System.out.println("4. Log out");
                    System.out.println("Enter your option :");
                    int choice3=scanner.nextInt();
                    
                    switch(choice3) {
                    
                    case 1:
                        System.out.println("Enter the Student id :");
                        int id=scanner.nextInt();
                        System.out.println("Enter the course id :");
                        int courseId=scanner.nextInt();
                        System.out.println("Enter the marks obtained : ");
                        int marks=scanner.nextInt();
                        System.out.println("Enter the maximum marks :");
                        int maxmarks=scanner.nextInt();
                        MarksManagement.addOrUpdateMarks(id, courseId, marks, maxmarks);
                        break;
                    
                    case 2:
                        int count2=0;
                        do {
                        
                        System.out.println("1. view a particular course's all marks");
                        System.out.println("2. view a particular student mark in a particular course");
                        System.out.println("3. view a particular student mark in all courses");
                        System.out.println("4. exit");
                        int choice4=scanner.nextInt();
                        scanner.nextLine();
                        
                        switch(choice4) {
                        
                        case 1 :
                            System.out.println("Enter the course id :");
                            int course_id=scanner.nextInt();
                            MarksViewing.viewAllStudentsInCourse(course_id);
                            break;
                            
                        case 2 :
                            System.out.println("Enter the Student id :");
                            int stud_id=scanner.nextInt();
                            System.out.println("Enter the course id :");
                            int c_id=scanner.nextInt();
                            MarksViewing.viewSingleStudentMarkInCourse(stud_id, c_id);
                            break;
                            
                        case 3:
                            System.out.println("Enter student Id :");
                            int s_id=scanner.nextInt();
                            MarksViewing.viewMarks(s_id);
                            break;
                            
                        case 4:
                            System.out.println("******Exited******");
                            count2=1;
                            break;
                            
                        default:
                            System.out.println("Invalid choice !!!");
                            break;
                            
                        }
                        } while(count2!=1);
                        break;
                      
                    case 3:
                    	
                    	int count5=0;
                    	do {
                    	
                    	System.out.println("1. GenerateSubjectWiseReport");
                    	System.out.println("2. GenerateOverallPerformanceReport");
                    	System.out.println("3. Topper Reports");
                    	System.out.println("4. Exit");
                    	System.out.println("Enter your choice :");
                    	int choice2=scanner.nextInt();
                    	scanner.nextLine();
                    		switch(choice2) {
                    	
                    		case 1:
                    			System.out.println("Enter the course Id :");
                    			int c_id=scanner.nextInt();
                    			ReportGenerator.generateSubjectWiseReport(c_id);
                    			break;
                    		case 2:
                    			ReportGenerator.generateOverallPerformanceReport();
                    			break;
                    		case 3 :
                    			int count6=0;
                    			do {
                    			System.out.println("1. Get the topper in a particular class for all courses.");
                    			System.out.println("2. Get the overall topper across all classes and courses.");
                    			System.out.println("3. Generate a report ordered from topper to lowest marks within a class");
                    			System.out.println("4. Generate a report ordered from topper to lowest marks across all classes.");
                    			System.out.println("5. Exit");
                    			
                    			System.out.println("Enter your choice");
                    			int choice5=scanner.nextInt();
                    			scanner.nextLine();
                    			switch(choice5) {
                    			case 1:
                    				System.out.println("Enter the department :");
                    				String dep4=scanner.nextLine();
                    				ReportGenerator.generateClassTopperReport(dep4);
                    				break;
                    			case 2:
                    				ReportGenerator.generateOverallTopperReport();
                    				break;
                    			case 3:
                    				System.out.println("Enter the department :");
                    				String dep5=scanner.nextLine();
                    				ReportGenerator.generateClassRankedReport(dep5);
                    				break;
                    			case 4:
                    				ReportGenerator.generateOverallRankedReport();
                    				break;
                    			case 5:
                    				System.out.println("******Exited******");
                    				count6=1;
                    				break;
                    			default:
                    			System.out.println("Invalid choice!!!");
                    			break;
                    			}
                    			}while(count6!=1);
                    			break;
                    		case 4 :
                    			System.out.println("******Exited******");
                    			count5=1;
                    			break;
                    		default:
                    			System.out.println("Invalid choice!!!");
                    			break;
                    		}
                    	}while(count5!=1);
                    	break;
                        
                    case 4 :
                        System.out.println("----Logged out----");
                        count1=1;
                        break;
                        
                    default:
                        System.out.println("Invalid Choice");
                        break;
                    
                    }
                    } while(count1!=1);
                    break;
                    
                case "student":
                	int studentId = UserAuthentication.getStudentIdByUsername(username);
                	if (studentId != -1) {
                	    System.out.println("Logged in as Student with ID: " + studentId);
                	    int count2=0;
                        do {

                            System.out.println("Student options...");
                            System.out.println("1. View marks");
                            System.out.println("2. Log out");
                            System.out.println("Enter your choice :");
                            int choice5=scanner.nextInt();
                            switch(choice5){
                                case 1:
                                    System.out.println("Your marks are as follows:");
                                    MarksViewing.viewMarks(studentId); 
                                    break;
                                case 2 :
                                    System.out.println("----Logged out----");
                                    count2 = 1;
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                                    break;
                                    
                            }
                        } while(count2!=1);
                        
                        break;
                        
                }
                	   
               else {
                	    System.out.println("Error retrieving student ID.");
                	}
                   
        } 
            scanner.close();
    }
        else {
            System.out.println("Invalid credentials.!!!");
        }
        scanner.close();

}
}