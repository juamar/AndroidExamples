package es.lhdev.googleMapsExample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MainActivity extends MainReMainActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private MapView mapView;
    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";
    private TextView tvCountry;
    private TextView tvCity;
    private Button buttonNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }

        mapView = findViewById(R.id.mapView1);
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);

        tvCity = findViewById(R.id.tvCity);
        tvCountry = findViewById(R.id.tvCountry);

        buttonNext = findViewById(R.id.button);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCameraMapActivity();
            }
        });
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

        //addingMarkerAndInverseGeocoding();
        //addingMarkerWithGeocoding();
        addingMarkerWithOurPosition();
    }

    public void addingMarkerAndInverseGeocoding()
    {
        List<Address> geocodeMatches = null;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);

        try{
            geocodeMatches = new Geocoder(this).getFromLocation(sydney.latitude, sydney.longitude, 1);
            tvCity.setText(geocodeMatches.get(0).getLocality());
            tvCountry.setText(geocodeMatches.get(0).getCountryName());
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").snippet(geocodeMatches.get(0).getLocality() + ", " + geocodeMatches.get(0).getCountryName()));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void addingMarkerWithGeocoding()
    {
        List<Address> geocodeMatches = null;

        try{
            geocodeMatches = new Geocoder(this).getFromLocationName("Plaza de España, Madrid",1);
            tvCity.setText(geocodeMatches.get(0).getLocality());
            tvCountry.setText(geocodeMatches.get(0).getCountryName());

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
}
