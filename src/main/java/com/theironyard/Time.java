package com.theironyard;

import javax.xml.bind.DatatypeConverter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Time {

    public static String convertTime(String time, int seconds, String timeZone) {

        Calendar cal = DatatypeConverter.parseDateTime(time);
        cal.add(Calendar.SECOND, seconds);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
        df.setTimeZone(TimeZone.getTimeZone(timeZone));
        String date = df.format(cal.getTime());

        return date;
    }
}
