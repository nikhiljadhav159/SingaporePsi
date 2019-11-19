package com.nikhijadhav.singaporepsi.models

import android.util.Log
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*


data class PsiApiResponse(
    @SerializedName("region_metadata")
    var regionMetadata: List<RegionMetadatum>?,
    @SerializedName("items")
    var items: List<Item>?,
    @SerializedName("api_info")
    var apiInfo: ApiInfo?
) {



}