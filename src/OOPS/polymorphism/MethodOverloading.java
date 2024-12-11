package OOPS.polymorphism;

public class MethodOverloading {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print();
        printer.print("Hello World");
    }
}

class Printer{
    public void print(){
        System.out.println("Printed");
    }

    public void print(String s){
        System.out.println(s);
    }
}
