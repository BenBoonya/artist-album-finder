package com.skooldio.android.artistalbumfinder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.skooldio.android.artistalbumfinder.adapter.ArtistAdapter
import com.skooldio.android.artistalbumfinder.model.Artist
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val artistList: List<Artist> = listOf(
                Artist("Twenty One Pilot", "Alternative"),
                Artist("Bodyslam", "Rock"),
                Artist("Retrospect", "Metal/Emo"),
                Artist("BNK48"),
                Artist("Oasis", "British Rock")
        )
        val adapter = ArtistAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        adapter.values = artistList
    }
}
