package emergency.com.crisisx;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import emergency.com.crisisx.api.AppUtils;
import emergency.com.crisisx.api.ProfilePrefs;
import emergency.com.crisisx.pojo.CalculateNearest;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportEmergency extends AppCompatActivity implements OnMapReadyCallback {

    ImageView mic;
    EditText decp;
    TextView reportLoc;
    FloatingActionButton fab;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    ProfilePrefs profilePrefs;
    Button getDefLoc;
    private LatLng markerLatLong, latLng;
    LocationGetter locationGetter;
    ImageView marker;

    double latitude = 19.025;
    double longitude = 75.065;
    double lat, lng;

    String address = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repostemergencyfrag);

        mic = (ImageView) findViewById(R.id.reportmic);
        marker = (ImageView) findViewById(R.id.img);
        decp = (EditText) findViewById(R.id.reportDescp);
        reportLoc = (TextView) findViewById(R.id.reportGeoLoc);
        fab = (FloatingActionButton) findViewById(R.id.reportfab);
        getDefLoc = (Button) findViewById(R.id.getDefaultLoc);
        profilePrefs = new ProfilePrefs(getApplicationContext());
        locationGetter = new LocationGetter(getApplicationContext());

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
        }

        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Description");
                try {
                    startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(), "Speech not supported", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EmergencyHandler emergencyHandler = new EmergencyHandler();
//                emergencyHandler.setUid(profilePrefs.getId());
//                emergencyHandler.setDescp(decp.getText().toString());
//                emergencyHandler.setLatlong(null);
//                EmergencyDb db = new EmergencyDb(getApplicationContext());
//                db.addReport(emergencyHandler);
//                Intent i = new Intent(getApplicationContext(), MainActivity.class);
//                i.putExtra("DESCP", decp.getText().toString());
//                startActivity(i);

                //TODO Emergency Post
                CalculateNearest calculateNearest = new CalculateNearest();
                calculateNearest.setEmergency_type(""+getIntent().getIntExtra("type", -1));
                calculateNearest.setLocation(latitude + "," + longitude);
                Log.d("Loc", latitude + "," + longitude);
                calculateNearest.setUID("123");

                AppUtils.serverApiService.reportEmergency(calculateNearest).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.code() == 200) {
                            Toast.makeText(ReportEmergency.this, "Emergency has been reported!!!", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(ReportEmergency.this, "Emergency couldn't be reported", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        getDefLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Location location = locationGetter.getLocation(LocationManager.GPS_PROVIDER);

                //you can hard-code the lat & long if you have issues with getting it
                //remove the below if-condition and use the following couple of lines
//                locationGetter = new LocationGetter(getApplicationContext());
//                locationGetter.getLocation()
                latitude = 19.025;
                longitude = 75.065;

                latitude = lat;
                longitude = lng;

                Geocoder geocoder;
                List<Address> addresses = new ArrayList<>();
                geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());


                try {
                    addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                } catch (IOException e) {
                    e.printStackTrace();
                }

                address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String postalCode = addresses.get(0).getPostalCode();
                String knownName = addresses.get(0).getFeatureName();
                reportLoc.setText(address);

            }
        });
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        latLng = new LatLng(19.0252138, 72.8503942);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 500));
        map.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override
            public void onCameraMove() {
               // map.setOnCameraChangeListener(null);
                //XP TYPE
               // map.addMarker(new MarkerOptions().position(latLng));
            }
        });
        map.setOnCameraMoveCanceledListener(new GoogleMap.OnCameraMoveCanceledListener() {
            @Override
            public void onCameraMoveCanceled() {
                map.addMarker(new MarkerOptions().position(latLng));
            }
        });
        map.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                Projection projection = map.getProjection();
                int cx = (marker.getRight() + marker.getLeft()) / 2;
                int cy = (marker.getTop() + marker.getBottom()) / 2;

                LatLng latLng = projection.fromScreenLocation(new Point(cx, cy));
                latitude = latLng.latitude;
                longitude = latLng.longitude;
                lat = latLng.latitude;
                lng = latLng.longitude;
            }
        });
//       // markerLatLong = latLng;
//        map.clear();
//        map.addMarker(new MarkerOptions().position(latLng));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    decp.setText(result.get(0));
                }
                break;
            }

        }
    }
}
