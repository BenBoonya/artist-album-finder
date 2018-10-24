package com.skooldio.android.artistalbumfinder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.skooldio.android.artistalbumfinder.model.Artist

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
    }
}
