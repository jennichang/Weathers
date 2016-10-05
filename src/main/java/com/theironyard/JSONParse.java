package com.theironyard;


import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParse {

    public static JSONArray ObjectToArray(JSONArray array, String arrayName, int index) {

        JSONObject object = array.getJSONObject(index);
        JSONArray jsonArray = object.getJSONArray(arrayName);
        return jsonArray;

    }






    JSONObject resultsObject = new JSONObject(result);
    JSONArray routesArray = resultsObject.getJSONArray("routes");

    JSONObject firstObject = routesArray.getJSONObject(0);
    JSONArray legsArray = firstObject.getJSONArray("legs");

    JSONObject secondObject = legsArray.getJSONObject(0);
    JSONArray stepsArray = secondObject.getJSONArray("steps");
}
