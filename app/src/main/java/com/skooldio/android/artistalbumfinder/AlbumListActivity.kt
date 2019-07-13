package com.skooldio.android.artistalbumfinder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.skooldio.android.artistalbumfinder.adapter.AlbumAdapter
import com.skooldio.android.artistalbumfinder.api.Api
import com.skooldio.android.artistalbumfinder.extension.toast
import com.skooldio.android.artistalbumfinder.model.Album
import com.skooldio.android.artistalbumfinder.model.AlbumApi
import com.skooldio.android.artistalbumfinder.model.ResponseWrapper
import kotlinx.android.synthetic.main.activity_album_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        Api.api.albumOfArtist(id).enqueue(object : Callback<ResponseWrapper<AlbumApi>> {
            override fun onFailure(call: Call<ResponseWrapper<AlbumApi>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ResponseWrapper<AlbumApi>>,
                response: Response<ResponseWrapper<AlbumApi>>
            ) {
                if (response.isSuccessful) {
                    (recyclerView.adapter as AlbumAdapter).values = response.body()?.result?.filter { it.wrapperType == "collection" }?.map {
                        Album(it.collectionName, it.date, it.trackCount, it.genreName)
                    } ?: ArrayList()
                }
            }
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