package com.theironyard;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jenniferchang on 10/6/16.
 */
public class GoogleGeocodingAPI {

    public static String googleGeocodingCall(double lng, double lat) {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> varsGeo = new HashMap<>();

        varsGeo.put("lng", String.valueOf(lng));
        varsGeo.put("lat", String.valueOf(lat));
        varsGeo.put("APIKey", "AIzaSyCcSbnI5cLmMWebMjAx63Wab2jp-_6UFF4");
        String result = restTemplate
                .getForObject(
                        "https://maps.googleapis.com/maps/api/geocode/json?latlng={lat},{lng}&key={APIKey}",
                        String.class, varsGeo);

        return result;

    }
}
