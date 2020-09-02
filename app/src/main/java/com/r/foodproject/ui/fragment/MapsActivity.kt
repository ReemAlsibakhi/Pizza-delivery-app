package com.r.foodproject.ui.fragment

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.r.foodproject.R

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

      //  getLastLocation()

        Dexter.withContext(this)
            .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse) {
                    val manager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
                    if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                        checkGPSEnable()
                    } else {
                        getLastLocation()
                    }
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse) {
              finish()
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?
                ) {
                    token!!.continuePermissionRequest()
                }
            }).check()
    }

    private fun getLastLocation() {

        val locationServices = LocationServices.getFusedLocationProviderClient(this)
        locationServices.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    val  lat = location.latitude
                    val longit = location.longitude
                    Log.e("lat", lat.toString())
                    Log.e("log", longit.toString())
                    val yourLocation = LatLng(lat,longit)

                    mMap.addMarker(MarkerOptions().position(yourLocation).snippet(" ").title("Marker in your location"))
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(yourLocation, 12.0f))

                    Toast.makeText(applicationContext, getString(R.string.send_pos), Toast.LENGTH_SHORT).show()
                //    finish()

                }
            }.addOnFailureListener { exception ->
                finish()

            }


    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        setUpMap()

    }

    private fun setUpMap() {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
   //     mMap.setMyLocationEnabled(true)
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isCompassEnabled = true
    }

    private fun checkGPSEnable() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
            .setCancelable(false)
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id
                ->
                startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
                finish()
            })
        val alert = dialogBuilder.create()
        alert.show()
    }
}
