
package enrollment;

import java.util.Scanner;

public class Enrollment {

    
    
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        String resp;
        
        do {
            System.out.println("1. ADD ENROLLMENT");
            System.out.println("2. VIEW ENROLLMENTS");
            System.out.println("3. UPDATE ENROLLMENT");
            System.out.println("4. DELETE ENROLLMENT");
            System.out.println("5. EXIT");
            
            System.out.print("Enter Action: ");
            int action = sc.nextInt();  
            Enrollment enrollment = new Enrollment();
            
            switch(action) {
                case 1:
                    enrollment.addEnrollment(); 
                    break;
                case 2:
                    enrollment.viewEnrollments(); 
                    break;
                case 3:
                    enrollment.viewEnrollments();  
                    enrollment.updateEnrollment();  
                    break;
                case 4:
                    enrollment.viewEnrollments(); 
                    enrollment.deleteEnrollment();  
                    enrollment.viewEnrollments();  
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (action != 5) {
                System.out.print("Continue? (yes/no): ");
                resp = sc.next();
            } else {
                resp = "no";
            }
        } while (resp.equalsIgnoreCase("yes"));

        System.out.println("Thank you!");
    }

  
    public void addEnrollment() {
        Scanner sc = new Scanner(System.in); 
        Config conf = new Config();  
        
        System.out.print("Student ID: ");
        int studentId = sc.nextInt();
        
        System.out.print("Course ID: ");
        int courseId = sc.nextInt();
        
        System.out.print("Enrollment Date (YYYY-MM-DD): ");
        String enrollmentDate = sc.next();
        
        System.out.print("Status: ");
        String status = sc.next();
        
        System.out.print("Semester: ");
        String semester = sc.next();
        
        String sql = "INSERT INTO enrollment (student_id, course_id, enrollment_date, status, semester) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, studentId, courseId, enrollmentDate, status, semester);
    }


    private void viewEnrollments() {
        String sql = "SELECT * FROM enrollment";
        String[] headers = {"Enrollment ID", "Student ID", "Course ID", "Enrollment Date", "Status", "Semester"};
        String[] columns = {"enrollment_id", "student_id", "course_id", "enrollment_date", "status", "semester"};
        
        Config conf = new Config();
        conf.viewRecords(sql, headers, columns);
    }

  
    private void updateEnrollment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Enrollment ID to update: ");
        int id = sc.nextInt();
        
        System.out.print("Enter new Student ID: ");
        int studentId = sc.nextInt();
        
        System.out.print("Enter new Course ID: ");
        int courseId = sc.nextInt();
        
        System.out.print("Enter new Enrollment Date (YYYY-MM-DD): ");
        String enrollmentDate = sc.next();
        
        System.out.print("Enter new Status: ");
        String status = sc.next();
        
        System.out.print("Enter new Semester: ");
        String semester = sc.next();
        
        String sql = "UPDATE enrollment SET student_id = ?, course_id = ?, enrollment_date = ?, status = ?, semester = ? WHERE enrollment_id = ?";
        Config conf = new Config();
        conf.updateRecord(sql, studentId, courseId, enrollmentDate, status, semester, id);
    }

  
    private void deleteEnrollment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Enrollment ID to delete: ");
        int id = sc.nextInt();
        
        String sql = "DELETE FROM enrollment WHERE enrollment_id = ?";
        Config conf = new Config();
        conf.deleteRecord(sql, id);
    }
}
       