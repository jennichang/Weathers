package com.theironyard;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;

import org.json.*;


@Controller
@EnableAutoConfiguration
public class WeathersController {

//    @RequestMapping("/")
//    @ResponseBody
//    String home() {
//        return "Hello World!";
//    }

    ArrayList<Step> stepsArray = new ArrayList<>();


    @CrossOrigin
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model) {

        return "test";
    }

    @CrossOrigin
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String locationInputs(HttpSession session, String startLocation, String endLocation,
                                 String startTime) throws FileNotFoundException, ParseException {
        Location userLocation = new Location(startLocation, endLocation, "2011-10-05T14:48:00.000Z"); //while testing
        session.setAttribute("userLocation", userLocation);


        /** Call Google Driving API **/

        JSONObject resultsObject = new JSONObject(GoogleDrivingAPI.googleDrivingCall(startLocation, endLocation));
        JSONArray routesArray = resultsObject.getJSONArray("routes");

        JSONArray legsArray = JSONParse.ObjectToArray(routesArray, "legs", 0);

        JSONArray stepsArray = JSONParse.ObjectToArray(legsArray, "steps", 0);

        /** For every step, get information I need **/
        //counter to keep track of time
        Calendar cal = DatatypeConverter.parseDateTime("2016-10-08T14:48:00.000Z");

        for (int i = 0; i < stepsArray.length(); i++) {

            JSONObject object = stepsArray.getJSONObject(i);

            int duration = JSONParse.objectToInteger(object, "duration", "value");

            LatLong startLatLong = JSONParse.objectToLatLong(object, "start_location");
            double startLng = startLatLong.getLng();
            double startLat = startLatLong.getLat();

            LatLong endLatLong = JSONParse.objectToLatLong(object, "end_location");
            double endLng = endLatLong.getLng();
            double endLat = endLatLong.getLat();

            String distance = JSONParse.objectToString(object, "distance", "text");


            /** call google geocoding API, feed in start and end lat and long **/

            JSONObject geoStart = new JSONObject(GoogleGeocodingAPI.googleGeocodingCall(startLng, startLat));
            JSONArray geoStartResults = geoStart.getJSONArray("results");

            JSONArray addressStartComponentsArray = JSONParse.ObjectToArray(geoStartResults, "address_components", 0);

            JSONObject geoEnd = new JSONObject(GoogleGeocodingAPI.googleGeocodingCall(endLng, endLat));
            JSONArray geoEndResults = geoStart.getJSONArray("results");

            JSONArray addressEndComponentsArray = JSONParse.ObjectToArray(geoEndResults, "address_components", 0);

            /** get zip code and routes for start and end **/
            String startRoute = "";
            String startZipCode = "";

            for (int j = 0; j < addressStartComponentsArray.length(); j++) {
                JSONObject tempObject = addressStartComponentsArray.getJSONObject(j);
                JSONArray typeArray = tempObject.getJSONArray("types");
                if (typeArray.toString().contains("route")) {
                    startRoute = tempObject.getString("short_name");
                } else if (typeArray.toString().contains("postal_code")) {
                    startZipCode = tempObject.getString("short_name");
                }
            }

            String endRoute = "";
            String endZipCode = "";

            for (int k = 0; k < addressEndComponentsArray.length(); k++) {
                JSONObject tempObject = addressEndComponentsArray.getJSONObject(k);
                JSONArray typeArray = tempObject.getJSONArray("types");
                if (typeArray.toString().contains("route")) {
                    endRoute = tempObject.getString("short_name");
                } else if (typeArray.toString().contains("postal_code")) {
                    endZipCode = tempObject.getString("short_name");
                }
            }

            /** call wunderground geo API, first need to get state, city and timezone **/

            JSONObject geoLookUpStart = new JSONObject(WundergroundAPI.wundergroundGeoLookUpCall(startZipCode));
            String startCity = JSONParse.objectToString(geoLookUpStart, "location", "city");
            String startState = JSONParse.objectToString(geoLookUpStart, "location", "state");
            String startTimeZone = JSONParse.objectToString(geoLookUpStart, "location", "tz_long");


            JSONObject geoLookupEnd = new JSONObject(WundergroundAPI.wundergroundGeoLookUpCall(endZipCode));
            String endCity = JSONParse.objectToString(geoLookupEnd, "location", "city");
            String endState = JSONParse.objectToString(geoLookupEnd, "location", "state");
            String endTimeZone = JSONParse.objectToString(geoLookupEnd, "location", "tz_long");

            //get start and end time of step:

            Calendar endTimeCal = (Calendar) cal.clone();
            Calendar startTimeCal = (Calendar) cal.clone();
            endTimeCal.add(Calendar.SECOND, duration); // why does this also add duration to start time?


            //now use the time to get the weather, first convert to time zone

            String startDateTimeZoned = Time.convertTime(startTimeCal, startTimeZone);
            String endDateTimeZoned = Time.convertTime(endTimeCal, endTimeZone);


            String startYear = String.valueOf(Time.convertToCalendar(startDateTimeZoned).get(Calendar.YEAR));
            String endYear = String.valueOf(Time.convertToCalendar(endDateTimeZoned).get(Calendar.YEAR));

            String startMonth = String.valueOf(Time.convertToCalendar(startDateTimeZoned).get(Calendar.MONTH) + 1);
            String endMonth = String.valueOf(Time.convertToCalendar(endDateTimeZoned).get(Calendar.MONTH) + 1);

            String startDate = String.valueOf(Time.convertToCalendar(startDateTimeZoned).get(Calendar.DATE));
            String endDate = String.valueOf(Time.convertToCalendar(endDateTimeZoned).get(Calendar.DATE));

            String startHour = String.valueOf(Time.roundHour(Time.convertToCalendar(startDateTimeZoned)));
            String endHour = String.valueOf(Time.roundHour(Time.convertToCalendar(endDateTimeZoned)));

            //now we can finally get the weather.

            JSONObject wundergroundStart = new JSONObject(WundergroundAPI.wundergroundCall(startState, startCity));
            JSONArray wundergroundStarArray = wundergroundStart.getJSONArray("hourly_forecast");

            String wConditionStart = "";
            String wTempStart = "";

            for (int l = 0; l < wundergroundStarArray.length(); l++) {
                JSONObject tempObject = wundergroundStarArray.getJSONObject(l);
                String test =  JSONParse.objectToString(tempObject, "FCTTIME", "mon_padded");
//                if (JSONParse.objectToString(tempObject, "FCTTIME", "mon_padded") == startMonth &&
//                        JSONParse.objectToString(tempObject, "FCTTIME", "year") == startYear &&
//                        JSONParse.objectToString(tempObject, "FCTTIME", "mday_padded") == startDate &&
//                        JSONParse.objectToString(tempObject, "FCTTIME", "hour_padded") == startHour) {

//                    wConditionStart = tempObject.getString("condition");
//                    wTempStart = String.valueOf(tempObject.getDouble("temp"));

                //}

            }

            String wConditionEnd = "";
            String wTempEnd = "";

            for (int m = 0; m < wundergroundStarArray.length(); m++) {
                JSONObject tempObject = wundergroundStarArray.getJSONObject(m);
                if (JSONParse.objectToString(tempObject, "FCTTIME", "mon_padded") == endMonth &&
                        JSONParse.objectToString(tempObject, "FCTTIME", "year") == endYear &&
                        JSONParse.objectToString(tempObject, "FCTTIME", "mday_padded") == endDate &&
                        JSONParse.objectToString(tempObject, "FCTTIME", "hour_padded") == endHour) {

                    wConditionEnd = tempObject.getString("condition");
                    wTempEnd = String.valueOf(tempObject.getDouble("temp"));

                }

            }

            cal = (Calendar) endTimeCal.clone();

            Step step = new Step(distance, duration, startDateTimeZoned, endDateTimeZoned, startCity, endCity,
                    startState, endState, startRoute, endRoute, startMonth, endMonth, startYear, endYear,
                    startDate, endDate, startHour, endHour, wConditionStart, wConditionEnd, wTempStart, wTempEnd);

            stepsArray.put(step);

        }


        return "redirect:/";
    }


    /**
     * placeholders for now....need to figure out how to do these get routes and have it work with the post routes
     **/

    @RequestMapping(path = "/summary", method = RequestMethod.GET)
    public Location summary(String startLocation, String endLocation, String startTime) {
        Location location = new Location(startLocation, endLocation, startTime);


        return location;
    }

    @RequestMapping(path = "/directions", method = RequestMethod.GET)
    public Location directions(String startLocation, String endLocation, String startTime) {
        Location location = new Location(startLocation, endLocation, startTime);

        return location;
    }


}


