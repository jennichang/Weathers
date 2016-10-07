package com.theironyard;

/**
 * Created by jenniferchang on 10/4/16.
 */
public class Step {
    String distance;
    int durationSeconds;
    String startTime;
    String endTime;
    String startCity;
    String endCity;
    String startState;
    String endState;
    String startRoute;
    String endRoute;
    String startMonth;
    String endMonth;
    String startYear;
    String endYear;
    String startDate;
    String endDate;
    String startHour;
    String endHour;
    String startCondition;
    String endCondition;
    String startTemp;
    String endTemp;

    public Step(String distance, int durationSeconds, String startTime, String endTime,
                String startCity, String endCity, String startState, String endState,
                String startRoute, String endRoute, String startMonth, String endMonth, String startYear,
                String endYear, String startDate, String endDate, String startHour, String endHour, String startCondition,
                String endCondition, String startTemp, String endTemp) {
        this.distance = distance;
        this.durationSeconds = durationSeconds;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startCity = startCity;
        this.endCity = endCity;
        this.startState = startState;
        this.endState = endState;
        this.startRoute = startRoute;
        this.endRoute = endRoute;
        this.startMonth = startMonth;
        this.endMonth = endMonth;
        this.startYear = startYear;
        this.endYear = endYear;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startHour = startHour;
        this.endHour = endHour;
        this.startCondition = startCondition;
        this.endCondition = endCondition;
        this.startTemp = startTemp;
        this.endTemp = endTemp;
    }
}
