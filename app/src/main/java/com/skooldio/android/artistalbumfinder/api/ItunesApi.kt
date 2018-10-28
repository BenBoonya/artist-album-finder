package com.skooldio.android.artistalbumfinder.api

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Boonya Kitpitak on 10/28/18.
 */
interface ItunesApi {

    @GET("/search")
    fun searchForArtist(@Query("term") artistName: String = "", @Query("entity") entity: String = "musicArtist")

    @GET("/lookup")
    fun albumOfArtist(@Query("id") artistId: Int, @Query("entity") entity: String = "album")

}