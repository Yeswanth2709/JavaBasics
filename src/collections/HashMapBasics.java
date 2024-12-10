package collections;

import java.util.*;

public class HashMapBasics {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("England", "London");
        hm.put("Germany", "Berlin");
        hm.put("Norway", "Oslo");
        hm.put("USA", "Washington DC");
        System.out.println(hm);

        //access an item
        System.out.println(hm.get("England"));

        //remove an item
        System.out.println(hm.remove("Germany"));
        System.out.println(hm);

        //to get keys and values
        for(String i: hm.keySet()){
            System.out.println(i + " : " + hm.get(i));
        }

        //to get only values
        for(String i: hm.values()){
            System.out.println(i);
        }

        //another way to loop through map
        for(Map.Entry<String,String> entry:hm.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        //find the frequency
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(3,2,1,4,5,2,1,4));
        HashMap<Integer,Integer> hm1=new HashMap<>();
        for(Integer i:al){
            hm1.put(i,hm1.getOrDefault(i,0)+1);
        }
        System.out.println(hm1);
    }
}
