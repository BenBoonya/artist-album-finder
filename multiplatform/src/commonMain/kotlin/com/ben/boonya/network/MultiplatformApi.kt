package com.ben.boonya.network

import com.ben.boonya.network.models.MultiplatformArtistApi
import com.ben.boonya.network.models.MultiplatformResponseWrapper
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JSON


class MultiplatformApi {

    private val client = HttpClient()

    fun fetchArtist(
        name: String,
        success: (List<MultiplatformArtistApi>) -> Unit,
        failure: (Throwable?) -> Unit
    ) {
        GlobalScope.launch {
            try {
                val json = client.get<String> {
                    url("$baseUrl/search?term=$name&entity=musicArtist&limit=15")
                }
                val result = JSON.nonstrict.parse(MultiplatformResponseWrapper.serializer(), json).results
                success(result)

            } catch (ex: Exception) {
                failure(ex)
            }
        }

    }

    companion object {
        private const val baseUrl = "https://itunes.apple.com"
    }
}