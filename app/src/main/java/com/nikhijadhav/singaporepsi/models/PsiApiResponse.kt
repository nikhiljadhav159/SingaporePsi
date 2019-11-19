package com.nikhijadhav.singaporepsi.models

data class PsiApiResponse(
    private val regionMetadata: List<RegionMetadatum>? = null,
    private val items: List<Item>? = null,
    private val apiInfo: ApiInfo? = null){
}