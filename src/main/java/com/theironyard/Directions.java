package com.theironyard;

/**
 * Created by jenniferchang on 10/4/16.
 */
public class Directions {
    String distance;
    int duration;
    double endLat;
    double endLong;
    double startLat;
    double startLong;
    String startZipCode;
    String startRoute;
    String endZipCode;
    String endRoute;



    public Directions(String distance, int duration, double endLat,
                      double endLong, double startLat, double startLong, String startZipCode,
                      String startRoute, String endZipCode, String endRoute) {
        this.distance = distance;
        this.duration = duration;
        this.endLat = endLat;
        this.endLong = endLong;
        this.startLat = startLat;
        this.startLong = startLong;
        this.startZipCode = startZipCode;
        this.startRoute = startRoute;
        this.endZipCode = endZipCode;
        this.endRoute = endRoute;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getEndLat() {
        return endLat;
    }

    public void setEndLat(double endLat) {
        this.endLat = endLat;
    }

    public double getEndLong() {
        return endLong;
    }

    public void setEndLong(double endLong) {
        this.endLong = endLong;
    }

    public double getStartLat() {
        return startLat;
    }

    public void setStartLat(double startLat) {
        this.startLat = startLat;
    }

    public double getStartLong() {
        return startLong;
    }

    public void setStartLong(double startLong) {
        this.startLong = startLong;
    }

    public String getStartZipCode() {
        return startZipCode;
    }

    public void setStartZipCode(String startZipCode) {
        this.startZipCode = startZipCode;
    }

    public String getStartRoute() {
        return startRoute;
    }

    public void setStartRoute(String startRoute) {
        this.startRoute = startRoute;
    }

    public String getEndZipCode() {
        return endZipCode;
    }

    public void setEndZipCode(String endZipCode) {
        this.endZipCode = endZipCode;
    }

    public String getEndRoute() {
        return endRoute;
    }

    public void setEndRoute(String endRoute) {
        this.endRoute = endRoute;
    }
}
