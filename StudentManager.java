import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentManager {
    private  ArrayList<Student> students=new ArrayList<>();
    private  Scanner scanner= new Scanner(System.in);
    private final String FILE_NAME= "students.txt";

//    CONSTRUCTOR: LOAD STUDENTS FROM FILE WHEN PROGRAM STARTS
    public StudentManager(){
        loadFromFile();
    }

//    METHOD TO ADD A NEW STUDENT
    public void addStudent(){
        System.out.println("Enter Student ID:");
        String id= scanner.nextLine();
        System.out.println("Enter Student Name:");
        String name=scanner.nextLine();
        System.out.println("Enter Student Age:");
        int age=Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Student Grade:");
        String grade= scanner.nextLine();

        Student student= new Student(id, name, age ,grade);
        students.add(student);
        saveToFile();
        System.out.println("Student added successfully");
    }

//    METHOD TO DISPLAY ALL STUDENTS
    public void viewAllStudents(){
        if(students.isEmpty()){
            System.out.println("No student to display");
        }
        else{
            for(Student student : students){
                System.out.println(student);
            }
        }
    }

//    METHOD TO SEARCH FOR A STUDENT BY ID
    public void searchStudentByID(){
        System.out.println("Enter Student ID to search:");
        String id= scanner.nextLine();
        for(Student student:students){
            if (student.getId().equals(id)){
                System.out.println(student);
            }
        }
        System.out.println("Student Not Found");
    }

//    METHOD TO UPDATE STUDENT DETAILS
    public void updateStudent(){
        System.out.println("Enter Student ID to Update:");
        String id= scanner.nextLine();
        for (Student student:students){
            if (student.getId().equals(id)){
                System.out.println("Enter new Name:");
                String name=scanner.nextLine();
                System.out.println("Enter new Age:");
                int age=Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new Grade:");
                String grade= scanner.nextLine();

                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);
                saveToFile();
                System.out.println("Details Updated");
            }
        }
        System.out.println("Student Not Found");

    }

//    METHOD TO DELETE A STUDENT
    public void  deleteStudent(){
        System.out.println("Enter Student ID to delete:");
        String id= scanner.nextLine();
        for (Student student:students){
            if (student.getId().equals(id)){
            students.remove(student);
                System.out.println("Student deleted successfully");
            }
        }
        System.out.println("Student Not Found");
    }

//    SAVE ALL STUDENTS TO FILE
    private void saveToFile(){
        try (BufferedWriter writer= new BufferedWriter(new FileWriter(FILE_NAME))){
            for (Student student: students){
                writer.write(student.getId()+","+ student.getName()+","+ student.getAge()+","+student.getGrade());
                writer.newLine();
            }

        } catch (IOException e){
            System.out.println("Error");
        }
    }

    private void loadFromFile(){
        try(BufferedReader reader= new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line= reader.readLine()) != null){
                String[] data= line.split(",");
                String id= data[0];
                String name= data[1];
                int age= Integer.parseInt(data[2]);
                String grade= data[3];
                students.add(new Student(id,name,age, grade));
            }

        } catch (FileNotFoundException e) {
            System.out.println("No existing student data found. Starting fresh");
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }

//    Menu to perform operations
    public void showMenu(){
        while(true){
            System.out.println("--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update a Student");
            System.out.println("5. Delete a Student");
            System.out.println("6. Exit");
            System.out.println("Choose a option");
            int choice= Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudentByID();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. PLease try again");
            }
        }
    }
}
