package OOPS.inheritance.example_3;

public class Example3 {
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

    public B(String s){
        System.out.println(s);
    }
}
class C extends B {
    public C(){
        super("hello");
        System.out.println("C");
    }
}
