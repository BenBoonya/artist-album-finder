package com.ben.boonya.network.models

import kotlinx.serialization.Serializable

@Serializable
class MultiplatformResponseWrapper(val resultCount: Int, val results: List<MultiplatformArtistApi>)