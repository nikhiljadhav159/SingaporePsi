package com.nikhijadhav.singaporepsi.models

import com.google.gson.annotations.SerializedName

data class Item(
     @SerializedName("timestamp")
     var timestamp: String? ,
     @SerializedName("update_timestamp")
     var updateTimestamp: String? ,
     @SerializedName("readings")
     var readings: Readings? ){
}