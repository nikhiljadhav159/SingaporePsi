package com.nikhijadhav.singaporepsi.models

import com.google.gson.annotations.SerializedName

data class CoEightHourMax(
     @SerializedName("west")
     var west: Double?,
     @SerializedName("national")
     var national: Double? ,
     @SerializedName("east")
     var east: Double? ,
     @SerializedName("central")
     var central: Double? ,
     @SerializedName("south")
     var south: Double? ,
     @SerializedName("north")
     var north: Double?
) {
}