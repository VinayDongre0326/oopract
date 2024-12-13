package assign8;
//class name StudentDatabase 
import java.io.*;
import java.util.*;

class Student  {
    private int studentId;
    private String name;
    private int rollNo;
    private String studentClass;
    private double marks;
    private String address;

    public Student(int studentId, String name, int rollNo, String studentClass, double marks, String address) {
        this.studentId = studentId;
        this.name = name;
        this.rollNo = rollNo;
        this.studentClass = studentClass;
        this.marks = marks;
        this.address = address;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public double getMarks() {
        return marks;
    }

    public String getAddress() {
        return address;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Class: " + studentClass);
        System.out.println("Marks: " + marks);
        System.out.println("Address: " + address);
        System.out.println("---------------------------");
    }
}

public class StudentDatabase {
    private static final String FILE_NAME = "student_records.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");

            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Roll No: ");
            int rollNo = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter Class: ");
            String studentClass = scanner.nextLine();

            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine(); 

            System.out.print("Enter Address: ");
            String address = scanner.nextLine();

            
            studentList.add(new Student(studentId, name, rollNo, studentClass, marks, address));
        }


        saveStudentRecords(studentList);

       
        displayStudentRecords();
        
        scanner.close();
    }


    private static void saveStudentRecords(List<Student> studentList) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(studentList);
            System.out.println("\nStudent records saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving student records: " + e.getMessage());
        }
    }

    private static void displayStudentRecords() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            @SuppressWarnings("unchecked")
            List<Student> studentList = (List<Student>) inputStream.readObject();

            System.out.println("\nStudent Records from file:");
            for (Student student : studentList) {
                student.displayDetails();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading student records: " + e.getMessage());
        }
    }
}