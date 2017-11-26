package com.analycer.greenter.greenter;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.analycer.greenter.greenter.util.MarkerData;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class ClientsMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        List<MarkerData> markersArray = new ArrayList<>();
        markersArray.add(new MarkerData(-12.073257, -77.076495,"WORTER","20562349845"));
        markersArray.add(new MarkerData(-12.073593, -77.061389,"START","20674453913"));
        markersArray.add(new MarkerData(-12.076910, -77.066035,"JOINNUS","20984567283"));
        markersArray.add(new MarkerData(-12.079837, -77.069747,"VENTURE","20673459839"));
        markersArray.add(new MarkerData(-12.083110, -77.063996,"WAYRA","20673541987"));
        markersArray.add(new MarkerData(-12.083718, -77.067011,"CTIC","20987536213"));
        markersArray.add(new MarkerData(-12.056104, -77.054995,"SUTER","20786543914"));
        markersArray.add(new MarkerData(-12.058223, -77.058793,"GERSIL","20876548122"));

        for(int i = 0 ; i < markersArray.size() ; i++ ) {

            createMarker(markersArray.get(i).getLatitude(), markersArray.get(i).getLongitude(), markersArray.get(i).getTitle(), markersArray.get(i).getSnippet(), markersArray.get(i).getIconResID());
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(markersArray.get(0).getLatitude(),markersArray.get(0).getLongitude())));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 12.8f ) );

    }

    protected Marker createMarker(double latitude, double longitude, String title, String snippet, int iconResID) {

        return mMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .anchor(0.5f, 0.5f)
                .title(title)
                .snippet(snippet));
//                .icon(BitmapDescriptorFactory.fromResource(iconResID)));
    }
}
