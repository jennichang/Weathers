package com.theironyard;


public class UserStart {
    String startZipCode;
    int month;
    int day;
    int year;
    String timeZone;

    public UserStart(String startZipCode, int month, int day, int year, String timeZone) {
        this.startZipCode = startZipCode;
        this.month = month;
        this.day = day;
        this.year = year;
        this.timeZone = timeZone;
    }
}
