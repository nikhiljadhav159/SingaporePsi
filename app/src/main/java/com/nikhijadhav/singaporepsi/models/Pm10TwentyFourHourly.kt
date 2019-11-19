package com.nikhijadhav.singaporepsi.models

import com.google.gson.annotations.SerializedName

data class Pm10TwentyFourHourly (
     @SerializedName("west")
     var west: Int? ,
     @SerializedName("national")
     var national: Int? ,
     @SerializedName("east")
     var east: Int? ,
     @SerializedName("central")
     var central: Int? ,
     @SerializedName("south")
     var south: Int? ,
     @SerializedName("north")
     var north: Int? ){
}