package com.theironyard;

import com.theironyard.routing.entities.GoogleRouteData;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jenniferchang on 10/6/16.
 */
public class GoogleDrivingAPI {

    public static GoogleRouteData getRouteFromGoogle(long startTime, String startLocation, String endLocation) {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<>();

        vars.put("startingLocation", startLocation);
        vars.put("endingLocation", endLocation);
        vars.put("APIKey", "AIzaSyASODlUfJtSvv-LqhnprK2jcaJ_rbThy9E");
        vars.put("departure_time", String.valueOf(startTime));
        GoogleRouteData result = restTemplate
                .getForObject(
                        "https://maps.googleapis.com/maps/api/directions/json?&departure_time={departure_time}&origin={startingLocation}&destination={endingLocation}&key={APIKey}",
                        GoogleRouteData.class, vars);

        return result;
    }
}
