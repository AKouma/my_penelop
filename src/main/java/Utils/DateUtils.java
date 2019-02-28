package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final String pattern = "dd/MM/aaaa";

    public static String getDate(Date date){
        String dateFormatted = null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        dateFormatted = formatter.format(date);
        return dateFormatted;
    }

}
