package com.ben.boonya.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

class MultiplatformApi {

    private val client = HttpClient()

    suspend fun fetchArtist(name: String): String {
        return client.get {
            url("$baseUrl/search?term=$name&entity=musicArtist")
        }
    }

    companion object {
        private const val baseUrl = "https://itunes.apple.com"
    }
}