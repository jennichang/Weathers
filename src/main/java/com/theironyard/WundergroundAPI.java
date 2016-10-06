package com.theironyard;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jenniferchang on 10/6/16.
 */
public class WundergroundAPI {

    public static String wundergroundCall(String zipCode) {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<>();

        vars.put("zipCode", zipCode);
        vars.put("APIKey", "6107aaed42fffb85");
        String result = restTemplate
                .getForObject(
                        "http://api.wunderground.com/api/{APIKey}/geolookup/q/{zipCode}.json",
                        String.class, vars);
        return result;
    }

}
