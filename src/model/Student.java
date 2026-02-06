package model;

/*Design Student class with:

✔ rollNo
✔ name
✔ email
✔ course
✔ constructor
✔ getters/setters
✔ display-friendly representation*/
public class Student {
    //I have created privae variable so that it should not get accessed by any of the object or construtor and no one muate it
    private int rollNo;
    private String name;
    private String email;
    private String course;

    //below I have initialised contructor for java to create object to store proper data
    public Student(int rollNo, String name, String email,String course){
        this.rollNo = rollNo;
        this.name = name;
        this.email= email;
        this.course = course;

    }
    @Override
    public String toString() {
        return "ID: " + rollNo +
               ", Name: " + name +
               ", Email: " + email +
               ", Course: " + course;
    }
    public int getRollNo() { return rollNo; }//not adding setter because this is unique and should not be mutable in future
    public String getName() { return name; }
    public void setName(String name) {
       this.name = name;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
     }
    public String getCourse() { return course; }
    public void setCourse(String course) {
        this.course = course;
     }
}
