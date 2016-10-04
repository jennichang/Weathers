package com.theironyard;


public class Location {
    String startLocation;
    String endLocation;
    String dateTime;

    public Location() {
    }

    public Location(String startLocation, String endLocation, String dateTime) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.dateTime = dateTime;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
