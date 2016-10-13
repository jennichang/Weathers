package com.theironyard.weather;

import com.theironyard.routing.entities.LatLong;
import com.theironyard.weather.entities.Weather;

/**
 * Created by Ben on 10/12/16.
 */
public interface WeatherAPI {
    Weather getWeatherAtTime(LatLong location, long epoch);
}
