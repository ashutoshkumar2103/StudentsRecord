import java.util.ArrayList;
import java.util.Scanner;

public class StudentsRecord {

    public static ArrayList<Student> studentsList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       int choice;

         do {
              System.out.println("1. Add Student");
              System.out.println("2. View Students");
              System.out.println("3. Update Student");
              System.out.println("4. Delete Student");
              System.out.println("5. Exit");
              System.out.print("Enter your choice: ");
              choice = sc.nextInt();
    
              switch (choice) {
                case 1:
                     addStudent();
                     break;
                case 2:
                     viewStudents();
                     break;
                case 3:
                     updateStudent();
                     break;
                case 4:
                     deleteStudent();
                     break;
                case 5:
                     System.out.println("Exiting....... Exited Successfully!");
                     break;
                default:
                     System.out.println("Invalid choice. Please try again.");
              }
         } while (choice != 5);

         sc.close();
    }

    public static void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (Student student : studentsList) {
            if (student.getId() == id) {
                System.out.println("Student with ID " + id + " already exists.");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student Marks: ");
        int marks = sc.nextInt();

        studentsList.add(new Student(id, name, marks)); // Create a new Student object and add it to the list (Student);
        System.out.println("Student added successfully!");
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        for (Student student : studentsList) {
            if (student.getId() == id) {
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                int marks = sc.nextInt();
                student.setName(name);
                student.setMarks(marks);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public static void viewStudents() {
        if (studentsList.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student student : studentsList) {
            student.displayStudentInfo();
        }
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        for (Student student : studentsList) {
            if (student.getId() == id) {
                studentsList.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

}