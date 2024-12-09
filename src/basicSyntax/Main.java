package basicSyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //java output/print
        // to print the output in a single line
        System.out.print("hello");
        System.out.print("world");
        // to print the output in a new line
        System.out.println("Hello");
        System.out.println("world");

        //java variables
        int myNum = 5;
        float myFloatNum = 5.99f;
        double myDoubleNum = 5.99;
        char myLetter = 'D';
        boolean myBool = true;
        String myText = "Hello";

        //Type conversion
        //convert string to int
        String num="300";
        int n=Integer.valueOf(num);
        int n2=500;
        String s=String.valueOf(n2);
        //arraysBasics();
    }

    public static void arraysBasics(){
        //1 D array
        int[] arr={1,2,3,4,5};
        for(int x:arr){
            System.out.println(x);
        }
        //2 D array
        int[][] arr1={{1,2,3},{4,5,6}};
        for(int[] x:arr1){
            for(int y:x){
                System.out.print(y);
            }
            System.out.println();
        }

        //split a string to array of characters

        String s="Hello";
        char[] ch=s.toCharArray();
        System.out.println(Arrays.toString(ch));

        //calculate the sum of integers in array
        int[] arr2={1,2,3,4,5};
        //without streams
        int sum=0;
        for(int i=0;i<arr2.length;i++){
            sum+=arr2[i];
        }
        System.out.println(sum);
        //with streams
        System.out.println(Arrays.stream(arr2)
                .sum());

        //find max element
        //without streams
        int maxElement=Integer.MIN_VALUE;
        for(int i=0;i<arr2.length;i++){
            if(arr2[i]>maxElement){
                maxElement=arr2[i];
            }
        }
        System.out.println(maxElement);
        //with streams
        Arrays.stream(arr2).max().ifPresent(System.out::println);
    }
}
