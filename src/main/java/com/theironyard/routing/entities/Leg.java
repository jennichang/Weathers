package com.theironyard.routing.entities;

import java.util.List;

/**
 * Created by Ben on 10/11/16.
 */
public class Leg {
    private TextValue distance;
    private TextValue duration;

    private List<Step> steps;

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public TextValue getDistance() {
        return distance;
    }

    public void setDistance(TextValue distance) {
        this.distance = distance;
    }

    public TextValue getDuration() {
        return duration;
    }

    public void setDuration(TextValue duration) {
        this.duration = duration;
    }
}
