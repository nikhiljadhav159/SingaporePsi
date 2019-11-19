package com.nikhijadhav.singaporepsi.apis

import com.nikhijadhav.singaporepsi.models.PsiApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface SingaporePsiApiData {

    @GET("psi")
    fun fetchPsiData(): Call<PsiApiResponse>
}