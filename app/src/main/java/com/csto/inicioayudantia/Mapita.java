package com.csto.inicioayudantia;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.csto.inicioayudantia.databinding.ActivityMapitaBinding;

public class Mapita extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapitaBinding binding;
    Float F;
    Double Latutud;
    Double Longitud;
    String S;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapitaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        Latutud = (double) 0;
        Longitud = (double) 0;
        Bundle b = getIntent().getExtras();
        F = b.getFloat("zoom");
        S = b.getString("Lug");
        if (S.equals("Lugar 1"))
        {
            Latutud = -35.42242867628466;
            Longitud = -71.70318245901748;

        }
        if (S.equals("Lugar 2"))
        {
            Latutud = 40.42343867049776;
            Longitud = -3.6332082018476033;

        }
        if (S.equals("Lugar 3"))
        {
            Latutud = 18.827858601157597;
            Longitud = -70.08899910790014;

        }

        // Add a marker in Sydney and move the camera
        LatLng marcador = new LatLng(Latutud, Longitud);
        mMap.addMarker(new MarkerOptions().position(marcador).title(S));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marcador, F));
    }
}