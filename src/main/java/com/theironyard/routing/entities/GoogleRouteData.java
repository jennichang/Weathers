package com.theironyard.routing.entities;

import java.util.List;

/**
 * Created by Ben on 10/11/16.
 */
public class GoogleRouteData {
    private String status;
    private List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
