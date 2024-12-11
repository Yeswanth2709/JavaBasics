package OOPS.access_modifiers.package1;

public class Student {
    private String name;
    String email;
    protected int age;

    private void print() {
        System.out.println("Name: " + name);
    }

    void cook(){
        print();
    }
}
