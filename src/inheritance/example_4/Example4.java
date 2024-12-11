package inheritance.example_4;

public class Example4 {
    public static void main(String[] args) {
        C c = new C();
    }
}
class A{
    public A(){
        System.out.println("A");
    }
}

class B extends A{
    public B(String s){
        System.out.println("B"+" :"+s);
    }
    public B(){
        System.out.println("B");
    }
    public B(B og){

    }
}
class C extends B{
    public C(){
        super("Hi");
        System.out.println("c");
    }
    public C(B b){
        super(b);
    }
}
