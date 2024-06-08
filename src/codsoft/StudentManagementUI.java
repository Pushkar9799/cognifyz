package codsoft;/*TASK 5
STUDENT MANAGEMENT SYSTEM
1.Create a codsoft.Student class to represent individual students. Include attributes such as name, roll
number, grade, and any other relevant details.
2.Implement a codsoft.StudentManagementSystem class to manage the collection of students. Include
methods to add a student, remove a student, search for a student, and display all students.
3.Design the user interface for the codsoft.Student Management System. This can be a console-based
interface or a graphical user interface (GUI) using libraries like Swing or JavaFX.
4.Implement methods to read and write student data to a storage medium, such as a file or a
database.
5.Allow users to interact with the codsoft.Student Management System by providing options such as
adding a new student, editing an existing student's information, searching for a student, displaying all
students, and exiting the application.
 6. Implement input validation to ensure that required fields are not left empty and that the student
data is in the correct format
*/



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student implements Serializable {
    private String name;
    private String rollNumber;
    private String grade;

    public Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "codsoft.Student{name='" + name + "', rollNumber='" + rollNumber + "', grade='" + grade + "'}";
    }
}

class StudentManagementSystem {
    private List<Student> students;
    private static final String FILE_NAME = "students.ser";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudents();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudents();
    }

    public void removeStudent(String rollNumber) {
        students.removeIf(student -> student.getRollNumber().equals(rollNumber));
        saveStudents();
    }

    public Student searchStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    private void saveStudents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.err.println("Error saving students: " + e.getMessage());
        }
    }

    private void loadStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File not found, no students to load
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading students: " + e.getMessage());
        }
    }
}

public class StudentManagementUI {
    private StudentManagementSystem sms;
    private Scanner scanner;

    public StudentManagementUI() {
        sms = new StudentManagementSystem();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("codsoft.Student Management System");
            System.out.println("1. Add codsoft.Student");
            System.out.println("2. Remove codsoft.Student");
            System.out.println("3. Search codsoft.Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    private void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        if (name.isEmpty() || rollNumber.isEmpty() || grade.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        Student student = new Student(name, rollNumber, grade);
        sms.addStudent(student);
        System.out.println("codsoft.Student added successfully.");
    }

    private void removeStudent() {
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();

        sms.removeStudent(rollNumber);
        System.out.println("codsoft.Student removed successfully.");
    }

    private void searchStudent() {
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();

        Student student = sms.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("codsoft.Student found: " + student);
        } else {
            System.out.println("codsoft.Student not found.");
        }
    }

    private void displayAllStudents() {
        for (Student student : sms.getAllStudents()) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentManagementUI ui = new StudentManagementUI();
        ui.start();
    }
}