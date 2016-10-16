package com.theironyard.viewmodel;

import com.theironyard.routing.entities.Step;
import com.theironyard.weather.entities.Weather;

import java.util.List;

/**
 * Created by Ben on 10/12/16.
 */
public class RouteWeatherViewModel {
    private Step step;
    private List<Weather> weathers;
    private long epochTime;

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public long getEpochTime() {
        return epochTime;
    }

    public void setEpochTime(long epochTime) {
        this.epochTime = epochTime;
    }
}
