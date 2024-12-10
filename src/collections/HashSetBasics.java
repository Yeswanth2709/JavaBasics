package collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetBasics {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("Volvo");
        set.add("BMW");
        set.add("Ford");
        set.add("BMW");
        set.add("Mazda");
        System.out.println(set);

        //check whether item is in set
        System.out.println(set.contains("Volvo"));

        //remove an item
        System.out.println(set.remove("BMW"));

        //loop through the set
        for(String i:set){
            System.out.println(i);
        }
    }
}
