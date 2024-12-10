package userInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name=sc.nextLine();
        // Input: Paul John
        // Output: Paul John
        System.out.println("Name is "+name);

        System.out.print("Enter an integer: ");
        int n=sc.nextInt();
        System.out.println("The number is "+n);

        System.out.print("Enter name: ");
        String name1=sc.next();
        // Input: Paul John
        // Output: Paul
        System.out.println("Name is "+name1);
    }
}
