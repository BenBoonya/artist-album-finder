package com.skooldio.android.artistalbumfinder.api

import com.skooldio.android.artistalbumfinder.model.ArtistApi
import com.skooldio.android.artistalbumfinder.model.BaseResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Boonya Kitpitak on 10/28/18.
 */
interface ItunesApi {

    @GET("/search")
    fun searchForArtist(@Query("term") artistName: String = "", @Query("entity") entity: String = "musicArtist"): Call<Response<ArtistApi>>

    @GET("/lookup")
    fun albumOfArtist(@Query("id") artistId: Int, @Query("entity") entity: String = "album"): Call<Response<BaseResponse>>

}