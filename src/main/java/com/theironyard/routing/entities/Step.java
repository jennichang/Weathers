package com.theironyard.routing.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ben on 10/11/16.
 */
public class Step {
    private TextValue distance;
    private TextValue duration;

    private LatLong start;
    private LatLong end;

    @JsonCreator
    public Step(
            @JsonProperty("start_location") LatLong start,
            @JsonProperty("end_location") LatLong end) {
        this.start = start;
        this.end = end;
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

    public LatLong getStart() {
        return start;
    }

    public void setStart(LatLong start) {
        this.start = start;
    }

    public LatLong getEnd() {
        return end;
    }

    public void setEnd(LatLong end) {
        this.end = end;
    }
}
