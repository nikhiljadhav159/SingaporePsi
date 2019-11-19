package com.nikhijadhav.singaporepsi.models

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

data class Item(
     @SerializedName("timestamp")
     var timestamp: String? ,
     @SerializedName("update_timestamp")
     var updateTimestamp: String? ,
     @SerializedName("readings")
     var readings: Readings? ){


}