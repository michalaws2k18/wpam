package com.example.android.roomwordssample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        title="Where is the grave? Map"
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


        val latitude =intent.extras?.getDouble("latitude")
        val longitude=intent.extras?.getDouble("longitude")
        // Add a marker in Sydney and move the camera
        val place = LatLng(latitude!!, longitude!!)

        val places=intent.extras?.getBoolean("places")
        if(places!!)
        {
            val type="kwiaciarnia"
            val PROXIMITY_RADIUS = 5000;
            mMap.addMarker(MarkerOptions().position(place).title("Marker in Place"))
            mMap.setContentDescription(type)
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 15.0f))

        }
        else{
            mMap.addMarker(MarkerOptions().position(place).title("Marker in Place"))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 15.0f))
        }


    }
}