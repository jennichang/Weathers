package com.theironyard.viewmodel;

import com.theironyard.routing.entities.Step;
import com.theironyard.weather.entities.Weather;

/**
 * Created by Ben on 10/12/16.
 */
public class RouteWeatherViewModel {
    private Step step;
    private Weather weather;
    private long epochTime;

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public long getEpochTime() {
        return epochTime;
    }

    public void setEpochTime(long epochTime) {
        this.epochTime = epochTime;
    }
}
