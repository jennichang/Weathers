package com.theironyard;

import jodd.json.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jenniferchang on 10/4/16.
 */
public class Directions {
    String distance;
    String duration;
    double endLat;
    double endLong;
    double startLat;
    double startLong;
    String zipCode;
    String route;

    public Directions(String distance, String duration, double endLat,
                      double endLong, double startLat, double startLong
                      //,String zipCode, String route
                      ) {
        this.distance = distance;
        this.duration = duration;
        this.endLat = endLat;
        this.endLong = endLong;
        this.startLat = startLat;
        this.startLong = startLong;
        //this.zipCode = zipCode;
        //this.route = route;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
