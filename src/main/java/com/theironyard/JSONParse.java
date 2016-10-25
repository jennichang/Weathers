package com.theironyard;


import com.theironyard.routing.entities.LatLong;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParse {

    public static JSONArray ObjectToArray(JSONArray array, String arrayName, int index) {

        JSONObject object = array.getJSONObject(index);
        JSONArray jsonArray = object.getJSONArray(arrayName);
        return jsonArray;

    }

    public static String objectToString(JSONObject jsonObject, String objectName, String getStringText) {

        JSONObject object = jsonObject.getJSONObject(objectName);
        String text = object.getString(getStringText);
        return text;
    }

    public static int objectToInteger(JSONObject jsonObject, String objectName, String getStringText) {

        JSONObject object = jsonObject.getJSONObject(objectName);
        int text = object.getInt(getStringText);
        return text;
    }

    public static LatLong objectToLatLong(JSONObject jsonObject, String objectName) {

        JSONObject object = jsonObject.getJSONObject(objectName);
        return new LatLong(object.getDouble("lat"), object.getDouble("lng"));
    }


}
