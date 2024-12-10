package collections;

import java.util.LinkedList;

public class LinkedListBasics {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        //add an element at head
        list.addFirst("e");
        //add an element at last
        list.addLast("f");
        System.out.println(list);
        //get first element
        System.out.println(list.getFirst());
        //get last element
        System.out.println(list.getLast());
        //remove first element
        System.out.println(list.removeFirst());
        //remove last element
        System.out.println(list.removeLast());
        System.out.println(list);
    }
}
