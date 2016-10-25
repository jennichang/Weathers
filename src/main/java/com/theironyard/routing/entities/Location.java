package com.theironyard.routing.entities;

/**
 * Created by Ben on 10/11/16.
 */
public class Location {
    private LatLong start;
    private LatLong end;

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
