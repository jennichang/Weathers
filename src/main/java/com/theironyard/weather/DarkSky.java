package com.theironyard.weather;

import com.theironyard.routing.entities.LatLong;
import com.theironyard.weather.entities.Weather;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ben on 10/12/16.
 */
public class DarkSky implements WeatherAPI {
    private static final String SECRET_KEY = "57136e19f4ee1a93c0c8a58d95c974d6";
    private static final String URI_TEMPLATE = "https://api.darksky.net/forecast/{key}/{latitude},{longitude},{time}?exclude=daily,hourly,flags";
    private static final RestTemplate template = new RestTemplate();

    @Override
    public Weather getWeatherAtTime(LatLong location, long epoch) {
        Map<String, String> params = new HashMap<>();

        params.put("key", SECRET_KEY);
        params.put("latitude", String.valueOf(location.getLat()));
        params.put("longitude", String.valueOf(location.getLng()));
        params.put("time", String.valueOf(epoch));

        return template.getForObject(URI_TEMPLATE, Weather.class, params);
    }
}
