package com.skooldio.android.artistalbumfinder.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Boonya Kitpitak on 10/28/18.
 */
object Api {
    val api: ItunesApi
    val gson = GsonBuilder().create()

    init {
        api = Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(ItunesApi::class.java)
    }
}