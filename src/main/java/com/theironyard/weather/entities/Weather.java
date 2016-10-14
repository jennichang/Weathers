package com.theironyard.weather.entities;

/**
 * Created by Ben on 10/12/16.
 */
public class Weather {
    private String latitude;
    private String longitude;

    private CurrentWeatherData currently;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public CurrentWeatherData getCurrently() {
        return currently;
    }

    public void setCurrently(CurrentWeatherData currently) {
        this.currently = currently;
    }

}
