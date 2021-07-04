package com.shenawynkov.test.networking


import android.provider.ContactsContract
import com.shenawynkov.test.networking.model.LineResponse
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query


interface ApiService {
    @GET(get_nutrition)
    suspend fun get_nutrition(
        @Query("app_id") AppID:String,
        @Query("app_key") app_key:String,
        @Query("ingr") ing:String


    ): LineResponse

}