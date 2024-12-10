package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBasics {
    public static void main(String[] args) {
        //create Date instance
        Date date = new Date();
        System.out.println(date);

        //Formatting the date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(date);
        System.out.println(dateString);
    }
}
