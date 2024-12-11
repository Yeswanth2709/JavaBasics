package OOPS.inheritance.example_5;

public class Example5 {
    public static void main(String[] args) {
        Instructor i=new Instructor("raju","raju@gmail.com","abc");
        System.out.println(i);
    }
}

class User{
    String name;
    String email;
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

class Instructor extends User{
    public String address;
    public Instructor(String name, String email, String address) {
        super(name, email);
        this.address=address;
    }

    public String toString() {
        return name+" "+email+" "+address;
    }
}