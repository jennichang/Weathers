package com.theironyard;

/**
 * Created by jenniferchang on 10/4/16.
 */
public class Directions {
    String distance;
    int durationSeconds;
    String startTime;
    String endTime;
    String startTimeZone;
    String endTimeZone;
    String startCity;
    String endCity;
    String startState;
    String endState;
    String startRoute;
    String endRoute;

    public Directions(String distance, int durationSeconds, String startTime, String endTime, String startTimeZone,
                      String endTimeZone, String startCity, String endCity, String startState, String endState,
                      String startRoute, String endRoute) {
        this.distance = distance;
        this.durationSeconds = durationSeconds;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startTimeZone = startTimeZone;
        this.endTimeZone = endTimeZone;
        this.startCity = startCity;
        this.endCity = endCity;
        this.startState = startState;
        this.endState = endState;
        this.startRoute = startRoute;
        this.endRoute = endRoute;
    }
}
