package com.example.adiligencia;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class ExerMap extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exer_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng CaxiasDoSul = new LatLng(-29.163937, -51.186809);
        mMap.addMarker(new MarkerOptions().position(CaxiasDoSul).title("Marker em Caxias do Sul"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CaxiasDoSul));

        LatLng gramado = new LatLng(-29.380007, -50.873681);
        mMap.addMarker(new MarkerOptions().position(gramado).title("Marker em Gramado"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gramado));

        LatLng portoAlegre = new LatLng(-30.064236, -51.181273);
        mMap.addMarker(new MarkerOptions().position(portoAlegre).title("marker em porto Alegre"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(portoAlegre));

        LatLng torres = new LatLng(-29.293338, -49.846895);
        mMap.addMarker(new MarkerOptions().position(torres).title("marker em Torres"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(torres));

        LatLng rolante = new LatLng( -29.610000, -50.565444);
        mMap.addMarker(new MarkerOptions().position(rolante).title("Ponto central"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rolante));



        //zoom
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(gramado, 8.0f));

        mMap.getUiSettings().setZoomControlsEnabled(true);

        //linhas
        mMap.addPolyline(new PolylineOptions()
                .width(10)
                .color(Color.BLUE)

                .add(CaxiasDoSul,gramado)
                .add(gramado,torres)
                .add(torres, portoAlegre)
                .add(portoAlegre,CaxiasDoSul)
        );

        mMap.addCircle(
                new CircleOptions()
                        .center(rolante)
                        .radius(77750.0)
                        .strokeWidth(3f)
                        .strokeColor(Color.RED)
                        .fillColor(Color.argb(60, 150, 50, 50)));

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
