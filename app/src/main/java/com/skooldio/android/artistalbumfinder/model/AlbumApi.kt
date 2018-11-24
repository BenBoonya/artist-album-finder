package com.skooldio.android.artistalbumfinder.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Boonya Kitpitak on 10/28/18.
 */

data class AlbumApi(
    @SerializedName("wrapperType") val wrapperType: String,
    @SerializedName("artistId") val artistId: String,
    @SerializedName("collectionId") val collectionId: String,
    @SerializedName("artistName") val artistName: String,
    @SerializedName("collectionName") val collectionName: String,
    @SerializedName("artworkUrl60") val artworkSmall: String,
    @SerializedName("artworkUrl100") val artworkBig: String,
    @SerializedName("trackCount") val trackCount: Int,
    @SerializedName("releaseDate") val date: String
)