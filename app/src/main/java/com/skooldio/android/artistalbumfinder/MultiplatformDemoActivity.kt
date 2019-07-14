package com.skooldio.android.artistalbumfinder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ben.boonya.createApplicationScreenMessage
import com.ben.boonya.network.MultiplatformApi
import com.skooldio.android.artistalbumfinder.adapter.ArtistAdapter
import com.skooldio.android.artistalbumfinder.model.Artist
import kotlinx.android.synthetic.main.activity_multiplatform_demo.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import kotlin.coroutines.CoroutineContext

class MultiplatformDemoActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplatform_demo)

        val adapter = ArtistAdapter {}
        multiplatformRecyclerView.adapter = adapter

        val multiplatformApi = MultiplatformApi()
        multiplatformTextView.text = createApplicationScreenMessage()
        multiplatformApi.fetchArtist("slayer", {
            launch(Main) {
                (multiplatformRecyclerView.adapter as ArtistAdapter).values = it.map {
                    Artist(it.artistName, it.primaryGenreName ?: "")
                }
            }
        }, {

        })
    }
}
