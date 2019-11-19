package com.nikhijadhav.singaporepsi.models

import com.google.gson.annotations.SerializedName

data class RegionMetadatum (
     @SerializedName("name")
     var name: String? ,
     @SerializedName("label_location")
     var labelLocation: LabelLocation? ){

     var readings :String = "default"
}