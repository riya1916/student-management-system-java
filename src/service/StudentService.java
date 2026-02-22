package service;
import java.util.ArrayList;

import model.Student;

//If a class will be used in another package →You must make constructor public

public class StudentService {

    ArrayList<Student> addStudents = new ArrayList<>();
//to add students
/* 
    public void addStudent() {

        Student s1 = new Student(1, "Riya", "test1@gmail.com", "CSE");
        addStudents.add(s1);

        Student s2 = new Student(2, "Aman", "test2@gmail.com", "IT");
        addStudents.add(s2);

        Student s3 = new Student(3,"Ayush", "ayush@gmail.com","Commerce");
        addStudents.add(s3);

    }*/
    /* here we have handled basic validation of null values-- 
    public void addStudent(int rollNo, String name, String email, String course) {
        for(Student st : addStudents){
            if(st.getRollNo()== rollNo){
                System.out.println("Student already added, please choose another roll no.");
                return;
            }
            }
        if(name == null ||  name.isBlank()){
            System.out.println("Name can not be blank.");
            return;
        }
        if(email == null ||  !email.contains("@")){
            System.out.println("Email format is invalid.");
            return;
        }
        if(course == null ||  course.isBlank()){
            System.out.println("Course can not be blank.");
            return;
        }
                Student s = new Student(rollNo, name, email, course);
                addStudents.add(s);
                System.out.println("Student added successfully");
    
}*/
//Now we gonnna check
public void addStudent(int rollNo, String name, String email, String course) {
    for(Student st : addStudents){
        if(st.getRollNo()== rollNo){
            //System.out.println("Student already added, please choose another roll no.");
            throw new IllegalArgumentException("Student already added, please choose another roll no.");
            //return;
        }
        }
    if(name == null ||  name.isBlank()){
        throw new IllegalArgumentException("Name can not be blank.");
    }
    if(email == null ||  !email.contains("@")){
        throw new IllegalArgumentException("Email format is invalid.");
        
    }
    if(course == null ||  course.isBlank()){
        throw new IllegalArgumentException("Course can not be blank.");
    }
            Student s = new Student(rollNo, name, email, course);
            addStudents.add(s);
            //System.out.println("Student added successfully");

}
    ///to display students
    public void displayStudents(){
        for(Student st : addStudents){
            System.out.println(st);
        }
    }

    //to Search Student
    public void searchStudent(int id){
        boolean found = false;

        for(Student st : addStudents){
            if(st.getRollNo()== id)
                found = true;
            System.out.println(st);
        }
        if(!found){
            System.out.println("Student not found");
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



