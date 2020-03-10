package com.tererai.weatherapp.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tererai.weatherapp.R;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private final String TAG = MapsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent mapIntent = getIntent();
        double latitude = mapIntent.getDoubleExtra("latitude", -0.00000);
        double longitude = mapIntent.getDoubleExtra("longitude", 0.00000);
        String cityLocated = mapIntent.getStringExtra("city");
        Log.d(TAG, latitude + " : " + longitude + " : " + cityLocated);
        LatLng city = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(city).title(cityLocated + " is here"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(city));
    }
}
