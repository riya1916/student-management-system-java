package service;
import java.util.ArrayList;

import model.Student;

//If a class will be used in another package →You must make constructor public

public class StudentService {

    ArrayList<Student> addStudents = new ArrayList<>();
//to add students
    public void addStudent() {

        Student s1 = new Student(1, "Riya", "test1@gmail.com", "CSE");
        addStudents.add(s1);

        Student s2 = new Student(2, "Aman", "test2@gmail.com", "IT");
        addStudents.add(s2);

        Student s3 = new Student(3,"Ayush", "ayush@gmail.com","Commerce");
        addStudents.add(s3);

    }
    ///to display students
    public void displayStudents(){
        for(Student st : addStudents){
            System.out.println(st);
        }
    }
    //to remove students
    public void removeStudents(){
        for(int i=0; i<addStudents.size(); i++){
            if(addStudents.get(i).getRollNo() == 2){
                addStudents.remove(i);
            }
        }
    }
    //to update students
    public void updateStudents(int rollNo, String name,String email, String course){
        boolean found = false;
        for(int i=0; i<addStudents.size();i++){
            if(addStudents.get(i).getRollNo() == rollNo){
                Student s = addStudents.get(i);
                /*if(name!=null || name!=""){
                    s.setName(name);
                }*/
                if(name != null && !name.isEmpty()){
                    s.setName(name);
                }

                s.setEmail(email);
                s.setCourse(course);
                found = true;
            }
        }
        if(!found){
            System.out.println("Roll Number does not exist");
        }
        else{
            System.out.println("Student " + rollNo + " details updated succesfully");
        }
    }
}



