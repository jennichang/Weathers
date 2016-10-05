package com.theironyard;

import jodd.json.JsonParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

import org.json.*;

import static org.springframework.http.HttpHeaders.USER_AGENT;

/**
 * Created by jenniferchang on 10/3/16.
 */
@Controller
@EnableAutoConfiguration
public class WeathersController {

//    @RequestMapping("/")
//    @ResponseBody
//    String home() {
//        return "Hello World!";
//    }


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model) {

        return "test";
    }


    //Post route to get the inputted data (starting location, ending location, start time)
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String locationInputs(HttpSession session, String startLocation, String endLocation,
                                 String dateTime) throws FileNotFoundException {
        Location userLocation = new Location(startLocation, endLocation, dateTime);
        session.setAttribute("userLocation", userLocation);

        // Call Google API
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<String, String>();

        vars.put("startingLocation", startLocation);
        vars.put("endingLocation", endLocation);
        vars.put("APIKey", "AIzaSyASODlUfJtSvv-LqhnprK2jcaJ_rbThy9E");
        String result = restTemplate
                .getForObject(
                        "https://maps.googleapis.com/maps/api/directions/json?origin={startingLocation}&destination={endingLocation}&key={APIKey}",
                        String.class, vars);

        //parse json file, put all steps as objects into an arraylist
        JSONObject resultsObject = new JSONObject(result);
        JSONArray routesArray = resultsObject.getJSONArray("routes");
        JSONObject firstObject = routesArray.getJSONObject(0);
        JSONArray legsArray = firstObject.getJSONArray("legs");
        JSONObject secondObject = legsArray.getJSONObject(0);
        JSONArray stepsArray = secondObject.getJSONArray("steps");

        ArrayList<Directions> directionsArray = new ArrayList<>();

        for (int i = 0; i < stepsArray.length(); i++) {
            JSONObject object = stepsArray.getJSONObject(i);
            JSONObject duration = object.getJSONObject("duration");
            String durationText = duration.getString("text");
            JSONObject startLoc = object.getJSONObject("start_location");
            double startLng = startLoc.getDouble("lng");
            double startLat = startLoc.getDouble("lat");
            JSONObject endLoc = object.getJSONObject("end_location");
            double endLng = endLoc.getDouble("lng");
            double endLat = endLoc.getDouble("lat");
            JSONObject distance = object.getJSONObject("distance");
            String distanceText = distance.getString("text");

            //call google geocoding
            Map<String, String> varsGeo = new HashMap<String, String>();

            varsGeo.put("startLng", String.valueOf(startLng));
            varsGeo.put("startLat", String.valueOf(startLat));
            varsGeo.put("endLng", String.valueOf(endLng));
            varsGeo.put("endLat", String.valueOf(endLat));
            varsGeo.put("APIKey", "AIzaSyCcSbnI5cLmMWebMjAx63Wab2jp-_6UFF4");
            String geoResultStart = restTemplate
                    .getForObject(
                            "https://maps.googleapis.com/maps/api/geocode/json?latlng={startLat},{startLng}&key={APIKey}",
                            String.class, varsGeo);
            String geoResultEnd = restTemplate
                    .getForObject(
                            "https://maps.googleapis.com/maps/api/geocode/json?latlng={endLat},{endLng}&key={APIKey}",
                            String.class, varsGeo);


            //parse json files
            JSONObject geoStart = new JSONObject(geoResultStart);
            JSONArray geoResultsArray = geoStart.getJSONArray("results");
            JSONObject routeObject = geoResultsArray.getJSONObject(0);
            JSONArray addressComponentsArray = routeObject.getJSONArray("address_components");

            for(int j = 0; j < addressComponentsArray.length(); j++) {
                JSONObject tempObject = addressComponentsArray.getJSONObject(j);
                if (tempObject.getString("type").equals("route")) {
                    String routeName = tempObject.getString("short_name");
                } else if(tempObject.getString("type").equals("postal_code")) {
                    String zipCode = tempObject.getString("postal_code");
                } break;
            }





            Directions directions = new Directions(distanceText, durationText, endLat, endLng, startLat, startLng);
            directionsArray.add(directions);
        }


        //call google

        return "redirect:/";
    }


    // Get route for summary page
    // need to return a
//    @RequestMapping(path = "/summary", method = RequestMethod.GET)
//    public String summary(HttpSession session, Model model) {
//
//


}
