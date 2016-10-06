package com.theironyard;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jenniferchang on 10/6/16.
 */
public class GoogleDrivingAPI {

    public static String googleDrivingCall(String startLocation, String endLocation) {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<>();

        vars.put("startingLocation", startLocation);
        vars.put("endingLocation", endLocation);
        vars.put("APIKey", "AIzaSyASODlUfJtSvv-LqhnprK2jcaJ_rbThy9E");
        String result = restTemplate
                .getForObject(
                        "https://maps.googleapis.com/maps/api/directions/json?origin={startingLocation}&destination={endingLocation}&key={APIKey}",
                        String.class, vars);

        return result;
    }
}
