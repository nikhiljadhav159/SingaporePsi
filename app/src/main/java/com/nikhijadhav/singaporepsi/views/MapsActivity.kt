package com.nikhijadhav.singaporepsi.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.nikhijadhav.singaporepsi.R
import com.nikhijadhav.singaporepsi.adapters.MarkerInfoWindowAdapter
import com.nikhijadhav.singaporepsi.apis.SingaporePsiApi
import com.nikhijadhav.singaporepsi.databinding.ActivityMapsBinding
import com.nikhijadhav.singaporepsi.viewmodels.MapViewModel

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var mapViewModel: MapViewModel
    private lateinit var activityMapsBinding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_maps)
        activityMapsBinding = DataBindingUtil.setContentView<ActivityMapsBinding>(this, R.layout.activity_maps)
        mapViewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)
        mapViewModel.apiClient = SingaporePsiApi(this)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        mapViewModel.callForPsiData()
        mapViewModel.lastUpdatedTimeStamp.observe(this, Observer {
            it.updateTimestamp = "Last Updated ${it.updateTimestamp}"
            activityMapsBinding.time = it
            activityMapsBinding.executePendingBindings()
        })

        mapViewModel.noInternetError.observe(
            this,
            Observer {
                if (it) {
                    Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Something Went Wrong..", Toast.LENGTH_SHORT).show()

                }

            })
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
        mMap.setInfoWindowAdapter(MarkerInfoWindowAdapter(layoutInflater));

        mapViewModel.regionList.observe(this, Observer { regionList ->
            mMap.clear()
            regionList.forEach {
                if (it.labelLocation!!.latitude!!.toInt() != 0 && it.labelLocation!!.longitude!!.toInt() != 0) {
                    mMap.addMarker(
                        MarkerOptions()
                            .position(LatLng(it.labelLocation!!.latitude!!, it.labelLocation!!.longitude!!))
                            .snippet(it.readings)
                    )
                    if (it.name!!.contentEquals("central")) {
                        mMap.moveCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                LatLng(
                                    it.labelLocation!!.latitude!!,
                                    it.labelLocation!!.longitude!!
                                ), 10f
                            )
                        )
                        mMap.animateCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                LatLng(
                                    it.labelLocation!!.latitude!!,
                                    it.labelLocation!!.longitude!!
                                ), 10f
                            )
                        )
                    }
                }
            }
        })


    }
}
