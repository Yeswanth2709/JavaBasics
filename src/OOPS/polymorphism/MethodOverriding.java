package OOPS.polymorphism;

public class MethodOverriding {
    public static void main(String[] args) {
        AA aa=new CC();
        aa.print();
        aa=new BB();
        aa.print();
        aa=new AA();
        aa.print();
    }
}

class AA{
    void print(){
        System.out.println("AA");
    }
}
class BB extends AA{
    void print(){
        System.out.println("BB");
    }
}
class CC extends BB{
    void print(){
        System.out.println("CC");
    }
}