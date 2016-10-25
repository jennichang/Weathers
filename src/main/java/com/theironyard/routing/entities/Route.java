package com.theironyard.routing.entities;

import java.util.List;

/**
 * Created by Ben on 10/11/16.
 */
public class Route {
    private List<Leg> legs;

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }
}
