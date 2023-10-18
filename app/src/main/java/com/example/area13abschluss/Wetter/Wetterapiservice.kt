package com.example.area13abschluss.Wetter

import com.example.area13abschluss.Wetter.Data.model.Data
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL ="http://api.weatherapi.com/v1/"



private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface WeaterApiService {
    @GET("current.json?key=5d978838e1d54b4ca4f135026232408&q=51.337258,12.306111")
    suspend fun getWeater():Data
}

object WeaterAPI {
    val retrofitservice:WeaterApiService by lazy { retrofit.create(WeaterApiService::class.java) }
}

