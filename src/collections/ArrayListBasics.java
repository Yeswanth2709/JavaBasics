package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListBasics {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        //add items to a list
        list.add("A");
        list.add("B");
        list.add("C");

        //add item at a particular index
        //if index<0 or index>size() it will throw exception
        list.add(1,"D");

        System.out.println(list);

        //access an item
        System.out.println(list.get(1));

        //change an item
        list.set(1,"E");

        //remove an item
        list.remove(2);
        System.out.println(list);

        //to clear the list
        list.clear();
        System.out.println(list);

        ArrayList<String> cars=new ArrayList<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Honda");
        cars.add("Audi");

        //to get size of the list
        int size=cars.size();

        //loop through the list
        for(int i=0;i<size;i++){
            System.out.println(cars.get(i));
        }
        //enhanced for loop
        for(String s:cars){
            System.out.println(s);
        }
        List<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(33);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(34);
        myNumbers.add(8);
        myNumbers.add(12);
        //sortIntegerListAsc(myNumbers);
        //sortIntegerListDesc(myNumbers);
        Comparator<Integer> compAsc=new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        Comparator<Integer> compDesc=new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        Collections.sort(myNumbers,compAsc);
        System.out.println(myNumbers);
        Collections.sort(myNumbers,compDesc);
        System.out.println(myNumbers);

    }

    public static void sortIntegerListAsc(List<Integer> list){
        Collections.sort(list);
    }

    public static void sortIntegerListDesc(List<Integer> list){
        Collections.sort(list,Collections.reverseOrder());
    }
}
