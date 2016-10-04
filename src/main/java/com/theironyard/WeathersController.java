package com.theironyard;

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
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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
                                 String dateTime) {
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
                        //"https://maps.googleapis.com/maps/api/directions/json?origin=Toronto&destination=Montreal&key={APIKey}",
                        "https://maps.googleapis.com/maps/api/directions/json?origin={startingLocation}&destination={endingLocation}&key={APIKey}",

                        String.class, vars);

        return "redirect:/summary";
    }

    // Get route for summary page
        // need to return a
    @RequestMapping(path = "/summary", method = RequestMethod.GET)
    public String summary(HttpSession session, Model model) {









//
//    // Post route to call Google Directions API
//    @RequestMapping(path = "/googleInfo", method = RequestMethod.POST)
//    public String locationInputs(HttpSession session) {
//        Location userLocation = (Location) session.getAttribute("userLocation");
//
//        String startLocation = userLocation.getStartLocation();
//        String endLocation = userLocation.getEndLocation();
//
//
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, String> vars = new HashMap<String, String>();
//
//        vars.put("startingLocation", startLocation);
//        vars.put("endingLocation", endLocation);
//        vars.put("APIKey", "AIzaSyASODlUfJtSvv-LqhnprK2jcaJ_rbThy9E");
//        String result = restTemplate
//                .getForObject(
//                        //"https://maps.googleapis.com/maps/api/directions/json?origin=Toronto&destination=Montreal&key={APIKey}",
//                        "https://maps.googleapis.com/maps/api/directions/json?origin={startingLocation}&destination={endingLocation}&key={APIKey}",
//
//                        String.class, vars);
//
//        return "redirect:/";
//    }


//
//    @RequestMapping(method = RequestMethod.POST)
//    public String weatherPost(@ModelAttribute City city, State state, ModelMap model) throws URISyntaxException {
//        String apiKey="myApIKey";//Removed my original API Key for posting.
//        RestTemplate template = new RestTemplate();
//        String strUri= "http://api.wunderground.com/api/" + apiKey + "/hourly/q/" + state + "/" + city + ".json";
//        URI uri = new URI(strUri);
//        RequestEntity<String> request = new RequestEntity<String>(HttpMethod.GET,uri);
//        ResponseEntity <WeatherResponse> weatherResponse = template.exchange(uri, HttpMethod.GET, request, WeatherResponse.class);
//        City myCity = new City();
//        model.put("weatherResponse", weatherResponse);
//        model.put("city", myCity);
//        return "weather";
//    }


}
