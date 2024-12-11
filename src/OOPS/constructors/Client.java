package OOPS.constructors;

public class Client {
    public static void main(String[] args) {
        Student s=new Student();
        System.out.println(s);
        Student s1=new Student(s);
        s1.setName("James");
        System.out.println(s1);
        System.out.println(s);

        Student s2=s1;
        s2.setName("Ravi");
        System.out.println(s2);
        System.out.println(s1);

        Student s3=new Student("rahul","rahul@gmail.com");
        System.out.println(s3);
    }
}
