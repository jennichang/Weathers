package com.theironyard;

import javax.xml.bind.DatatypeConverter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Time {

    public static String convertTime(Calendar calInput, String timeZone) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
        df.setTimeZone(TimeZone.getTimeZone(timeZone));
        String date = df.format(calInput.getTime());
        return date;
    }

    public static Calendar convertToCalendar(String dateString) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Calendar cal  = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        return cal;
    }


    public static String roundHour(Calendar cal) {
        int hour = Integer.valueOf(cal.get(Calendar.HOUR_OF_DAY));
        int minute = Integer.valueOf(cal.get(Calendar.MINUTE));

        if (minute <= 30) {
            hour = hour;
        } else {
            hour = hour + 1;

        }
        String hourString = String.valueOf(hour);

        return hourString;
    }

}
