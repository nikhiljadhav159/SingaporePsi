package com.nikhijadhav.singaporepsi.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.nikhijadhav.singaporepsi.R


class MarkerInfoWindowAdapter(private var inflater: LayoutInflater) : GoogleMap.InfoWindowAdapter {
    private var popup: View? = null

    override fun getInfoWindow(marker: Marker): View? {
        return null
    }

    @SuppressLint("InflateParams")
    override fun getInfoContents(marker: Marker): View {
        if (popup == null) {
            popup = inflater.inflate(R.layout.popup, null)
        }

        /*var tvTitle = popup!!.findViewById<View>(R.id.title) as TextView

        tvTitle.text = marker.title*/
        var tvSnippet = popup!!.findViewById(R.id.snippet) as TextView
        tvSnippet.text = marker.snippet

        return popup as View
    }
}