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
    String startCity;
    String startState;
    String endZipCode;
    String endRoute;
    String endCity;
    String endState;
    String startTimeZone;
    String endTimeZone;

    public Directions(String distance, int duration, double endLat, double endLong, double startLat, double startLong,
                      String startZipCode, String startRoute, String startCity, String startState, String endZipCode,
                      String endRoute, String endCity, String endState, String startTimeZone, String endTimeZone) {
        this.distance = distance;
        this.duration = duration;
        this.endLat = endLat;
        this.endLong = endLong;
        this.startLat = startLat;
        this.startLong = startLong;
        this.startZipCode = startZipCode;
        this.startRoute = startRoute;
        this.startCity = startCity;
        this.startState = startState;
        this.endZipCode = endZipCode;
        this.endRoute = endRoute;
        this.endCity = endCity;
        this.endState = endState;
        this.startTimeZone = startTimeZone;
        this.endTimeZone = endTimeZone;
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

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getStartState() {
        return startState;
    }

    public void setStartState(String startState) {
        this.startState = startState;
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

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public String getEndState() {
        return endState;
    }

    public void setEndState(String endState) {
        this.endState = endState;
    }

    public String getStartTimeZone() {
        return startTimeZone;
    }

    public void setStartTimeZone(String startTimeZone) {
        this.startTimeZone = startTimeZone;
    }

    public String getEndTimeZone() {
        return endTimeZone;
    }

    public void setEndTimeZone(String endTimeZone) {
        this.endTimeZone = endTimeZone;
    }
}
