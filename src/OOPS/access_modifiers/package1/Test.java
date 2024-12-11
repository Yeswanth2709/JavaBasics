package OOPS.access_modifiers.package1;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
//        System.out.println(s1.name); cannot access because name field is private;
        System.out.println(s1.email);//can access because email is default;
//        s1.print() it is a private method cannot access
        System.out.println(s1.age); //it is a protected field it can be accessed in the same package and the child classes
    }
}
