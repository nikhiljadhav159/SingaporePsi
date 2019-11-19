package com.nikhijadhav.singaporepsi.models

import com.google.gson.annotations.SerializedName

data class PsiApiResponse(
     @SerializedName("region_metadata")
     var regionMetadata: List<RegionMetadatum>? ,
     @SerializedName("items")
     var items: List<Item>? ,
     @SerializedName("api_info")
     var apiInfo: ApiInfo? ){


}