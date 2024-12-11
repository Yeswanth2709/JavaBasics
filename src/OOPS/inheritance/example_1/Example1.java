package OOPS.inheritance.example_1;

public class Example1 {
    public static void main(String[] args) {
        //in the constructor there will be a call to parents constructor
        C c=new C();

    }
}

//Example for  multi-level OOPS.inheritance
class A {
    public A(){
        System.out.println("A");
    }
}
class B extends A {
    public B(){
        System.out.println("B");
    }
}
class C extends B {
    public C(){
        System.out.println("C");
    }
}
