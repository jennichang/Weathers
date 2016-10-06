package com.theironyard;


public class UserStart {
    private String startZipCode;
    private String timeUTC;

    public UserStart(String startZipCode, String timeUTC) {
        this.startZipCode = startZipCode;
        this.timeUTC = timeUTC;
    }

    public String getStartZipCode() {
        return startZipCode;
    }

    public void setStartZipCode(String startZipCode) {
        this.startZipCode = startZipCode;
    }

    public String getTimeUTC() {
        return timeUTC;
    }

    public void setTimeUTC(String timeUTC) {
        this.timeUTC = timeUTC;
    }
}
