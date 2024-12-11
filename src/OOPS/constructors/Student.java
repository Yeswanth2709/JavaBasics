package OOPS.constructors;

public class Student {
    private String name;
    private String email;

    //no-args constructor
    public Student(){
        name="Raju";
        email="raju@gmail.com";
    }

    //copy constructor
    public Student(Student s){
        name=s.name;
        email=s.email;
    }

    //constructor with arguments
    public Student(String name, String email){
        this.name=name;
        this.email=email;
    }

    public String toString(){
        return name+"\n"+email;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
