package com.udacity.asteroidradar.api

import com.squareup.moshi.Moshi
import com.udacity.asteroidradar.network.ImageNetwork
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


//private val moshi = Moshi.Builder().
//        add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory()).build()
//
//private val retrofit = Retrofit.Builder().
//    addConverterFactory(MoshiConverterFactory.create(moshi)).
//    baseUrl(Constants.BASE_URL).build()
//
//interface Json {
//@GET("neo/rest/v1/feed?api_key=" + Constants.MY_API_KEY)
//suspend fun getAsteroid():String
//}
//
//interface Image {
//    @GET("planetary/apod?api_key=" + Constants.MY_API_KEY)
//    suspend fun getImage():ImageNetwork
//}
//
//object AsteroidApi {
//    val asteroidJson:Json by lazy{
//        retrofit.create(Json::class.java)
//    }
//    val imageResponse:Image by lazy{
//        retrofit.create(Image::class.java)
//    }
//}

