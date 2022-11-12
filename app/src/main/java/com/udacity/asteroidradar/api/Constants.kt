package com.udacity.asteroidradar.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.api.Constants.BASE_URL
import com.udacity.asteroidradar.network.ImageNetwork
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object Constants {
    const val API_QUERY_DATE_FORMAT = "YYYY-MM-dd"
    const val DEFAULT_END_DATE_DAYS = 7
    const val BASE_URL = "https://api.nasa.gov/"
    const val MY_API_KEY="6jcEidRaxbyvJisbR1Rme1IghedUYLy9JsC8K5f8"
}

    //   Moshi Builder to create a Moshi object with the KotlinJsonAdapterFactory
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    // ConverterFactory to the MoshiConverterFactory with our Moshi Object
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface Json {
    @GET("neo/rest/v1/feed?api_key=" + Constants.MY_API_KEY)
    suspend fun getAsteroid():String
    @GET("planetary/apod?api_key=" + Constants.MY_API_KEY)
    suspend fun getImage(): ImageNetwork
}

object AsteroidApi {
    val asteroidJson:Json by lazy{
        retrofit.create(Json::class.java)
    }
    val imageResponse:Json by lazy{
        retrofit.create(Json::class.java)
    }
}
