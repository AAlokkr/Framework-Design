package utils;

import java.util.Date;

public class DateUtils {

    public static String getTimeStamp() {
        return new Date().toString().replaceAll(":", "_").replaceAll(" ", "_");
    }
}
