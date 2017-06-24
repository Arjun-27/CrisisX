package emergency.com.crisisx.api;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import emergency.com.crisisx.pojo.LocationInfo;

/**
 * Created by Arjun on 26-Mar-2017 for CrisisX.
 */

public class MySharedPreference {

    private static final String MEM_NAME = "Memory";
    private static final String DEFAULT_LOCATIONS = "defaultLocations";
    private static final String HOSPITAL_LOCATIONS =  "hospitalLocations";
    private static final String POLICE_LOCATIONS =  "policeLocations";
    private static final String FIRE_LOCATIONS =  "fireLocations";

    public static boolean saveAllLocationDetails(List<LocationInfo> locationInfoList, Context context, int type) {
        SharedPreferences.Editor editor = context.getSharedPreferences(MEM_NAME, 0).edit();
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(locationInfoList, new TypeToken<List<LocationInfo>>() {}.getType());
        String locationListStr = jsonElement.getAsJsonArray().toString();

        switch (type) {
            case 0:
                editor.putString(DEFAULT_LOCATIONS + HOSPITAL_LOCATIONS, locationListStr);
                return editor.commit();

            case 1:
                editor.putString(DEFAULT_LOCATIONS + POLICE_LOCATIONS, locationListStr);
                return editor.commit();

            case 2:
                editor.putString(DEFAULT_LOCATIONS + FIRE_LOCATIONS, locationListStr);
                return editor.commit();
        }

        return false;
    }

    public static List<LocationInfo> getAllLocationDetails(Context context, int type) {
        Type listType = new TypeToken<List<LocationInfo>>() {}.getType();
        String key = "";
        switch (type) {
            case 0:
                key = HOSPITAL_LOCATIONS;
                break;

            case 1:
                key = POLICE_LOCATIONS;
                break;

            case 2:
                key = FIRE_LOCATIONS;
                break;
        }
        return new Gson().fromJson(context.getSharedPreferences(MEM_NAME, 0).getString(DEFAULT_LOCATIONS + key, ""), listType);
    }
}
