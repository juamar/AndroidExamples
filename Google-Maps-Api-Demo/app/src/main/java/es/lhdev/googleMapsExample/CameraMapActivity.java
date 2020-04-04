package es.lhdev.googleMapsExample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.List;

public class CameraMapActivity extends MainReMainActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapView mapView;
    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_map);

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }

        mapView = findViewById(R.id.mapView1);
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle);
        }

        mapView.onSaveInstanceState(mapViewBundle);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Check out we are saving GoogleMap instance for future use.
        mMap = googleMap;
        addingMarkerWithOurPosition();
    }

    public void addingMarkerWithGeocoding()
    {
        List<Address> geocodeMatches = null;

        try{
            geocodeMatches = new Geocoder(this).getFromLocationName("Plaza de España, Madrid",1);

            LatLng latLng = new LatLng(geocodeMatches.get(0).getLatitude(),geocodeMatches.get(0).getLongitude());

            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker").snippet(geocodeMatches.get(0).getLocality() + ", " + geocodeMatches.get(0).getCountryName()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

            UiSettings mySettings = mMap.getUiSettings();
            mySettings.setZoomControlsEnabled(true);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addingMarkerWithOurPosition() {
        if (mMap != null)
        {
            int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
            if (permission == PackageManager.PERMISSION_GRANTED)
            {
                mMap.setMyLocationEnabled(true);
            }
            else
            {
                requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_REQUEST_CODE);
            }
            addingMarkerWithGeocoding();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case LOCATION_REQUEST_CODE:
                mapView.getMapAsync(this);
        }
    }

    public void onTiltMorePressed(View v)
    {
        if (mMap != null)
        {
            CameraPosition cameraPosition = new CameraPosition.Builder(mMap.getCameraPosition())
                    .tilt(mMap.getCameraPosition().tilt + 10)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
        else
        {
            Log.e(this.getClass().getSimpleName(), "Map is null!");
        }
    }

    public void onTiltLessPressed(View v)
    {
        if (mMap != null)
        {
            CameraPosition cameraPosition = new CameraPosition.Builder(mMap.getCameraPosition())
                    .tilt(mMap.getCameraPosition().tilt - 10)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
        else
        {
            Log.e(this.getClass().getSimpleName(), "Map is null!");
        }
    }

    public void onBearingMorePressed(View v)
    {
        if (mMap != null)
        {
            CameraPosition cameraPosition = new CameraPosition.Builder(mMap.getCameraPosition())
                    .bearing(mMap.getCameraPosition().bearing + 10)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
        else
        {
            Log.e(this.getClass().getSimpleName(), "Map is null!");
        }
    }

    public void onBearingLessPressed(View v)
    {
        if (mMap != null)
        {
            CameraPosition cameraPosition = new CameraPosition.Builder(mMap.getCameraPosition())
                    .bearing(mMap.getCameraPosition().bearing - 10)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
        else
        {
            Log.e(this.getClass().getSimpleName(), "Map is null!");
        }
    }

    public void onNextPressed(View v)
    {
        startBasicMap();
    }
}
