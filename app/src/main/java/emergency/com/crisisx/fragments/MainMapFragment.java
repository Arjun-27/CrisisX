package emergency.com.crisisx.fragments;

import android.Manifest;

import android.animation.Animator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import emergency.com.crisisx.R;
import emergency.com.crisisx.api.AppUtils;
import emergency.com.crisisx.api.MySharedPreference;
import emergency.com.crisisx.pojo.LocationInfo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Arjun on 23-Mar-2017 for CrisisX.
 */

public class MainMapFragment extends SupportMapFragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{

    private GoogleApiClient mGoogleApiClient;

    private static final String TAG = "MAP";

    private final int[] MAP_TYPES = {GoogleMap.MAP_TYPE_SATELLITE,
            GoogleMap.MAP_TYPE_NORMAL,
            GoogleMap.MAP_TYPE_HYBRID,
            GoogleMap.MAP_TYPE_TERRAIN,
            GoogleMap.MAP_TYPE_NONE};

    private int curMapTypeIndex = 2;

    private List<LocationInfo> hospitalLocations, policeLocations, fireStationLocations;

    private GoogleMap googleMap;

    private BroadcastReceiver receiver;
    private IntentFilter filter;

    private Marker marker;

    @Override
    public void onStart() {
        super.onStart();
        mGoogleApiClient.connect();

        hospitalLocations = MySharedPreference.getAllLocationDetails(getContext(), 0);
        policeLocations = MySharedPreference.getAllLocationDetails(getContext(), 1);
        fireStationLocations = MySharedPreference.getAllLocationDetails(getContext(), 2);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
//        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);

        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(getContext(), "Please grant permissions to proceed..", Toast.LENGTH_SHORT).show();
        } else {
            initCamera();
        }
    }

    private void setAppropriateLocations(int type, Response<ResponseBody> response) {
        try {
            JSONArray results = new JSONObject(response.body().string()).getJSONArray("results");

            List<LocationInfo> list = new ArrayList<>();

            for(int i = 0; i < results.length(); i++) {
                JSONObject object = results.getJSONObject(i);
                LocationInfo locationInfo = new LocationInfo();

                JSONObject objLocation = object.getJSONObject("geometry").getJSONObject("location");
                locationInfo.setLatitude(objLocation.getDouble("lat"));
                locationInfo.setLongitude(objLocation.getDouble("lng"));
                locationInfo.setId(object.getString("id"));
                locationInfo.setName(object.getString("name"));
                locationInfo.setPlace_id(object.getString("place_id"));
                locationInfo.setTypes(object.getJSONArray("types").toString().replace("[", "").replace("]","").split("/, "));
                locationInfo.setVicinity(object.getString("vicinity"));

                list.add(locationInfo);
            }

            switch (type) {
                case 0:
                    hospitalLocations = list;
                    MySharedPreference.saveAllLocationDetails(list, getContext(), 0);
                    plotLocations(0);
                    break;

                case 1:
                    policeLocations = list;
                    MySharedPreference.saveAllLocationDetails(list, getContext(), 1);
                    plotLocations(1);
                    break;

                case 2:
                    fireStationLocations = list;
                    MySharedPreference.saveAllLocationDetails(list, getContext(), 2);
                    plotLocations(2);
                    break;

            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    private void initCamera() {
        final CameraPosition position = CameraPosition.builder()
                .target(new LatLng(18.462393, 73.865076))
                .zoom(12f)
                .bearing(0.0f)
                .tilt(0.0f)
                .build();

        /* Methods Not Called */
        getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(position), null);
                googleMap.setMapType(MAP_TYPES[curMapTypeIndex]);

                marker = googleMap.addMarker(new MarkerOptions().position(new LatLng(19.021236, 72.858961)).icon(BitmapDescriptorFactory.fromResource(R.drawable.ambulance)));

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                googleMap.setMyLocationEnabled(true);
                googleMap.setTrafficEnabled(true);

                MainMapFragment.this.googleMap = googleMap;

                if(hospitalLocations == null) {
                    AppUtils.googleApiService.getAllEmergencyHelpLocations("18.462393, 73.865076", 5000, "hospital", getActivity().getString(R.string.my_google_api_key)).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            setAppropriateLocations(0, response);
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(getContext(), "Could not get near-by hospitals", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    plotLocations(0);
                }

                if(policeLocations == null) {
                    AppUtils.googleApiService.getAllEmergencyHelpLocations("18.462393, 73.865076", 5000, "police", getActivity().getString(R.string.my_google_api_key)).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            setAppropriateLocations(1, response);
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(getContext(), "Could not get near-by police stations", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    plotLocations(1);
                }

                if(fireStationLocations == null) {
                    AppUtils.googleApiService.getAllEmergencyHelpLocations("18.462393, 73.865076", 5000, "fire_station", getActivity().getString(R.string.google_api_key)).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            setAppropriateLocations(2, response);
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(getContext(), "Could not get near-by fire-stations", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    plotLocations(2);
                }
            }
        });
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public void onResume() {
        super.onResume();
        filter = new IntentFilter("LOCATIONS");

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals(filter.getAction(0))) {
                    String[] subloc = intent.getStringExtra("location").split(",");
                    animateMarker(marker, new LatLng(Double.parseDouble(subloc[0]), Double.parseDouble(subloc[1])), false);
                }
            }
        };

        getActivity().registerReceiver(receiver, filter);
    }

    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(receiver);
    }

    private void plotLocations(int type) {
        List<LocationInfo> locationInfoList;
        BitmapDescriptor bitmapDescriptor;

        //TODO: Add Specific icons for each case
        switch (type) {
            case 0:
                locationInfoList = hospitalLocations;
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.ambulance);
                break;

            case 1:
                locationInfoList = policeLocations;
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.police_car);
                break;

            case 2:
                locationInfoList = fireStationLocations;
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.fire_station);
                break;

            default:
                locationInfoList = new ArrayList<>();
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.ambulance);
        }
        Marker marker = null;
        for(LocationInfo info : locationInfoList) {
            marker = googleMap.addMarker(new MarkerOptions().position(new LatLng(info.getLatitude(), info.getLongitude())).flat(false).icon(bitmapDescriptor).title(info.getName()));
        }

        //animateMarker(marker, new LatLng(18.462393, 73.865076), false);
    }

    public void animateMarker(final Marker marker, final LatLng toPosition, final boolean hideMarker) {
        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        Projection proj = googleMap.getProjection();
        Point startPoint = proj.toScreenLocation(marker.getPosition());
        final LatLng startLatLng = proj.fromScreenLocation(startPoint);
        final long duration = 5000;

        final Interpolator interpolator = new LinearInterpolator();

        handler.post(new Runnable() {
            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - start;
                float t = interpolator.getInterpolation((float) elapsed
                        / duration);
                double lng = t * toPosition.longitude + (1 - t)
                        * startLatLng.longitude;
                double lat = t * toPosition.latitude + (1 - t)
                        * startLatLng.latitude;
                marker.setPosition(new LatLng(lat, lng));

                if (t < 1.0) {
                    // Post again 16ms later.
                    handler.postDelayed(this, 16);
                } else {
                    if (hideMarker) {
                        marker.setVisible(false);
                    } else {
                        marker.setVisible(true);
                    }
                }
            }
        });
    }
}
