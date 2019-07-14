package com.ben.boonya.network.models

import kotlinx.serialization.Serializable

@Serializable
class MultiplatformArtistApi(
    val wrapperType: String,
    val artistType: String,
    val artistName: String,
    val artistLinkUrl: String,
    val artistId: Int,
    val primaryGenreName: String,
    val primaryGenreId: Int
)