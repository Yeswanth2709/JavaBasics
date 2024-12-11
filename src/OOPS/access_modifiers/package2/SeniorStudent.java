package OOPS.access_modifiers.package2;

import OOPS.access_modifiers.package1.Student;

public class SeniorStudent extends Student {
    void print(){
        //System.out.println(email); default field
        System.out.println(age);
        //System.out.println(name); private field
    }
}
