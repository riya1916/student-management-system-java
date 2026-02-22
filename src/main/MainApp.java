package main;

import java.util.Scanner;

import service.StudentService;

public class MainApp {
    public static void main(String args[]){
        /*StudentService service = new StudentService();

        service.addStudent();
        service.displayStudents();
        service.removeStudents();
        //service.displayStudents();// to again display students after deleting rollno2.
        service.updateStudents(4, "anshi", "anshi@gmail.com", "bba");
        service.updateStudents(3, "Riya", "abc@gmail.com", "BTech");//to update srudent data
        service.updateStudents(1, "", "anshi@gmail.com", "bba");
        service.displayStudents();
        */
        
        // here we gonna take input to add user from user only no hardcoded data--
        

        Scanner sc =  new Scanner(System.in);
        StudentService service = new StudentService();
        while(true){
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            //System.out.println("3. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.println("5. Enter your choice: ");

            int choice = sc.nextInt();
        
            switch(choice){

                case 1:
                    //add student
                    System.out.println("Enter roll no ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();//after taking integer input, we need to add this(IMPORTANT),Otherwise next string input gets skipped.
                    System.out.println("Enter name ");
                    String name = sc.nextLine();

                    System.out.println("Enter email ");
                    String email = sc.nextLine();

                    System.out.println("Enter course ");
                    String course = sc.nextLine();
                    service.addStudent(rollNo,name, email, course);
                    break;
                case 2:
                    //view student
                    System.out.println("Enter roll no ");
                    rollNo = sc.nextInt();
                    sc.nextLine();
                    service.displayStudents();
                    break;
                case 3:
                    System.out.println("Enter roll no of student to search");
                    int id = sc.nextInt();
                    sc.nextLine();
                    service.searchStudent(id);
                    break;
                case 4:
                        System.out.println("Exiting....");
                        sc.close();
                        return;
                default:
                    System.out.println("Choice doesn't exist....");
                    
            }
        }
    }
}
