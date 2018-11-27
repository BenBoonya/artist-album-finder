package com.skooldio.android.artistalbumfinder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.skooldio.android.artistalbumfinder.adapter.AlbumAdapter
import com.skooldio.android.artistalbumfinder.api.Api
import com.skooldio.android.artistalbumfinder.extension.enqueue
import com.skooldio.android.artistalbumfinder.extension.toast
import com.skooldio.android.artistalbumfinder.model.Album
import kotlinx.android.synthetic.main.activity_album_list.*

/**
 * Created by Boonya Kitpitak on 10/27/18.
 */
class AlbumListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_list)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val artistName: String = intent?.extras?.getString(MainActivity.ARTIST_NAME_EXTRA) ?: ""
        val artistId: Int = intent?.extras?.getInt(MainActivity.ARTIST_ID_EXTRA) ?: 0
        title = artistName

        val adapter = AlbumAdapter {
            toast(getString(R.string.label_number_of_track_in_album, it.name, it.trackCount.toString()))
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@AlbumListActivity, LinearLayoutManager.VERTICAL, false)
            this.adapter = adapter
        }

        getAlbumByArtistId(artistId)
    }

    private fun getAlbumByArtistId(id: Int) {
        Api.api.albumOfArtist(id).enqueue({
            (recyclerView.adapter as AlbumAdapter).values = it?.result?.filter { it.wrapperType == "collection" }?.map { album ->
                Album(album.collectionName, album.date, album.trackCount, album.genreName)
            } ?: ArrayList()
        }, {
            toast(getString(R.string.label_error_message))
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}