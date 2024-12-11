package RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo {
    public static void main(String[] args) {

        String pattern="School";
        String text="W3Schools";
        System.out.println(findMatch(text,pattern));
        pattern="[abc]";
        text="W3Shools";
        System.out.println(findMatch(text,pattern));
        pattern="[^abc]";
        text="abccbd";
        System.out.println(findMatch(text,pattern));
    }

    public static boolean findMatch(String text, String pattern) {
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(text);
        return matcher.find();
    }
}
