package OOPS.access_modifiers.package2;

import OOPS.access_modifiers.package1.Student;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
//        System.out.println(s1.name); cannot access because name field is private;
       // System.out.println(s1.email);//cannot access because email is in different package and it is not public;
//        s1.print() it is a private method cannot access
       // System.out.println(s1.age); //it is a protected field it cannot be accessed outside package
    }
}
