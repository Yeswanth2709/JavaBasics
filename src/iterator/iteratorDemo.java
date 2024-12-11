package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class iteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c","d","e","f","g","h"));
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
