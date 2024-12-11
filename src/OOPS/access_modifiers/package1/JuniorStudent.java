package OOPS.access_modifiers.package1;

public class JuniorStudent extends Student {
    void print(){
//        System.out.println(name);//cannot access private field
        System.out.println(email);
        System.out.println(age);
    }
}
