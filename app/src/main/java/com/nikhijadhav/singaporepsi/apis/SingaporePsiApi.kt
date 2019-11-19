package com.nikhijadhav.singaporepsi.apis

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.nikhijadhav.singaporepsi.models.PsiApiResponse
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class SingaporePsiApi(var context: Context) {
    val cacheSize = (5 * 1024 * 1024).toLong()
    val appCache = Cache(context.cacheDir, cacheSize)
    val cacheTime = 60 * 60 * 2 //2 hours

    private var service: SingaporePsiApiData

    init {
        //region Setting up the okHttpClient for retrofit
        val okHttp: OkHttpClient = OkHttpClient.Builder()
            .cache(appCache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (hasNetwork(context)!!)
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 1).build()
                else
                    request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=$cacheTime").build()
                chain.proceed(request)
            }
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .build()
        //endregion

        //region Setting up the retrofit request
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.data.gov.sg/v1/environment/")
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //endregion

        //region creating a retrofit service request for InformationData class
        service = retrofit.create(SingaporePsiApiData::class.java)
        //endregion
    }

    fun getInformation(callback: Callback<PsiApiResponse>) {
        //region creating call for service request and handle the call back from request
        val call = service.fetchPsiData()
        call.enqueue(callback)
        //endregion
    }


    @SuppressLint("ServiceCast")
    fun hasNetwork(context: Context): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }

}