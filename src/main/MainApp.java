package main;

import service.StudentService;

public class MainApp {
    public static void main(String args[]){
        StudentService service = new StudentService();

        service.addStudent();
        service.displayStudents();
        service.removeStudents();
        //service.displayStudents();// to again display students after deleting rollno2.
        service.updateStudents(4, "anshi", "anshi@gmail.com", "bba");
        service.updateStudents(3, "Riya", "abc@gmail.com", "BTech");//to update srudent data
        service.updateStudents(1, "", "anshi@gmail.com", "bba");
       
        service.displayStudents();


    }
}
