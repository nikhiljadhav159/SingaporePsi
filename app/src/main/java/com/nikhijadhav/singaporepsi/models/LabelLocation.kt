package com.nikhijadhav.singaporepsi.models

import com.google.gson.annotations.SerializedName

data class LabelLocation(
     @SerializedName("latitude")
     var latitude: Double? ,
     @SerializedName("longitude")
     var longitude: Double?
) {
}