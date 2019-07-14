package com.skooldio.android.artistalbumfinder

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.ben.boonya.analytics.AnalyticsManager
import com.ben.boonya.analytics.events.ViewArtistAlbumEvent
import com.skooldio.android.artistalbumfinder.adapter.ArtistAdapter
import com.skooldio.android.artistalbumfinder.api.Api
import com.skooldio.android.artistalbumfinder.extension.enqueue
import com.skooldio.android.artistalbumfinder.extension.toast
import com.skooldio.android.artistalbumfinder.model.Artist
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val analyticsManager: AnalyticsManager by lazy { ArtistAlbumFinderAnalytic() }

    companion object {
        const val ARTIST_NAME_EXTRA = "artist_name_extra"
        const val ARTIST_ID_EXTRA = "artist_id_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArtistAdapter {
            navigateToAlbumList(it)
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            this.adapter = adapter
        }

        fab.setOnClickListener {
            navigateToMultiplatformDemo()
        }

        getArtistList("body")
    }

    private fun getArtistList(searchKey: String) {
        Api.api.searchForArtist(searchKey).enqueue({
            (recyclerView.adapter as ArtistAdapter).values = it?.result?.map { album ->
                Artist(album.name, album.genreName, album.artistId.toInt())
            } ?: ArrayList()
        }, { toast(getString(R.string.label_error_message)) })
    }

    private fun navigateToAlbumList(artist: Artist) {
        analyticsManager.report(ViewArtistAlbumEvent())
        val intent = Intent(this, AlbumListActivity::class.java).apply {
            putExtra(ARTIST_NAME_EXTRA, artist.name)
            putExtra(ARTIST_ID_EXTRA, artist.id)
        }
        startActivity(intent)
    }

    private fun navigateToMultiplatformDemo() {
        val intent = Intent(this, MultiplatformDemoActivity::class.java)
        startActivity(intent)
    }
}
