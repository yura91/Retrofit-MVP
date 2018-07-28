package registration.testing.firebase.com.retrofitmvp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
    public static String convertToReadableTime(long timestamp) {
        long ts = Long.valueOf(timestamp) * 1000;// its need to be in milisecond
        Date df = new java.util.Date(ts);
        String dr = new SimpleDateFormat("dd MM , yyyy").format(df);
        return dr;
    }
}
