package service;
import java.util.ArrayList;
import java.io.*;


import model.Student;

//If a class will be used in another package →You must make constructor public

public class StudentService {

    ArrayList<Student> addStudents = new ArrayList<>();
    public static final String FILE_NAME = "student.txt";
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
            saveToFile();
}
    ///to display students
    public void displayStudents(){
        for(Student st : addStudents){
            System.out.println(st);
        }
    }

    //to Search Student
    //here now we have handled everything throw main, from here we will return not print.
    public Student searchStudent(int id){

        for(Student st : addStudents){
            if(st.getRollNo()== id){
                //System.out.println(st);
                return st;
            }
                
        }
        throw new IllegalArgumentException("Student not found.");
    }
    //to remove students
    public void removeStudents(){
        for(int i=0; i<addStudents.size(); i++){
            if(addStudents.get(i).getRollNo() == 2){
                addStudents.remove(i);
            }
        }
        saveToFile();
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
        saveToFile();
    }

    public void saveToFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME)))
        {
            for( Student st : addStudents){
                String line = st.getRollNo() + "," +
                st.getName() + ","+
                st.getEmail() + ","+
                st.getCourse();

                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error saving data to file.");
        }
    }

    public void loadFromFile() {
        addStudents.clear();
        File file = new File(FILE_NAME);
    
        if (!file.exists()) {
            return; // no file yet
        }
    
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
    
            String line;
    
            while ((line = reader.readLine()) != null) {
    
                String[] data = line.split(",");
    
                int rollNo = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                String course = data[3];
    
                Student st = new Student(rollNo, name, email, course);
                addStudents.add(st);
            }
    
        } catch (IOException e) {
            throw new RuntimeException("Error loading data from file.");
        }
    }
    
}




