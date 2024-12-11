package OOPS.polymorphism;

public class Example {
    public static void main(String[] args) {
        A obj=new C();
        System.out.println(obj.a);
        System.out.println(obj.b);
        //System.out.println(obj.c);
        //System.out.println(obj.d);

        obj=new B();
        System.out.println(obj.a);
        System.out.println(obj.b);
        //System.out.println(obj.c);
        //System.out.println(obj.d);

        B obj2=new C();
        System.out.println(obj2.a);
        System.out.println(obj2.b);
        System.out.println(obj2.c);
        //System.out.println(obj2.d);
    }
}

class A{
    int a;
    int b;
}

class B extends A{
    int c;
}

class C extends B{
    int d;
}