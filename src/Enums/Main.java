package Enums;

public class Main {
    public static void main(String[] args) {
        Level val=Level.LOW;
        System.out.println(val);

        //switch statement
        switch(val){
            case LOW:
                System.out.println("LOW");
                break;
            case MEDIUM:
                System.out.println("MEDIUM");
                break;
            case HIGH:
                System.out.println("HIGH");
                break;
            default:
                System.out.println("DEFAULT");
                break;
        }

        //loop through enums
        for(Level l:Level.values()){
            System.out.println(l);
        }
    }
}
