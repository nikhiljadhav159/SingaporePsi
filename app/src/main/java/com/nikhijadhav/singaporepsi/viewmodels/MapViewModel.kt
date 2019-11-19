package com.nikhijadhav.singaporepsi.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikhijadhav.singaporepsi.apis.SingaporePsiApi
import com.nikhijadhav.singaporepsi.models.Item
import com.nikhijadhav.singaporepsi.models.PsiApiResponse
import com.nikhijadhav.singaporepsi.models.RegionMetadatum
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.UnknownHostException

open class MapViewModel : ViewModel() {

    val TAG = MapViewModel::class.java.simpleName
    var regionList = MutableLiveData<ArrayList<RegionMetadatum>>()
    var lastUpdatedTimeStamp = MutableLiveData<Item>()
    lateinit var apiClient: SingaporePsiApi
    var noInternetError = MutableLiveData<Boolean>()

    fun callForPsiData() {
        //region creating a callback for response
        val callback = object : Callback<PsiApiResponse> {

            override fun onResponse(call: Call<PsiApiResponse>?, response: Response<PsiApiResponse>?) {
                try {
                    val informationResponse = response!!.body()!!
                    lastUpdatedTimeStamp.value = informationResponse.items!![0]
                    val regionMetadataList = informationResponse.regionMetadata as ArrayList<RegionMetadatum>

                    regionMetadataList.forEach {
                        when (it.name) {
                            "north" -> {
                                it.readings = informationResponse.items!![0].readings!!.getReadingsDataFor("north")
                            }
                            "south" -> {
                                it.readings = informationResponse.items!![0].readings!!.getReadingsDataFor("south")
                            }
                            "central" -> {
                                it.readings = informationResponse.items!![0].readings!!.getReadingsDataFor("central")
                            }
                            "east" -> {
                                it.readings = informationResponse.items!![0].readings!!.getReadingsDataFor("east")
                            }
                            "west" -> {
                                it.readings = informationResponse.items!![0].readings!!.getReadingsDataFor("west")
                            }
                        }

                    }

                    regionList.value = regionMetadataList
                } catch (e: Exception) {
                    e.printStackTrace()
                    noInternetError.value = true
                }
            }


            override fun onFailure(call: Call<PsiApiResponse>?, t: Throwable?) {
                Log.e(TAG, t.toString())
                if (t is UnknownHostException) {
                    noInternetError.postValue(true)
                } else {
                    noInternetError.postValue(false)
                }
            }

        }
        //endregion

        //region create request call and handle the callback
        apiClient.getInformation(callback)
        //endregion
    }

}