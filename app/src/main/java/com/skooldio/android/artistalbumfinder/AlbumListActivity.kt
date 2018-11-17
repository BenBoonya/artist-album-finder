package com.skooldio.android.artistalbumfinder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
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

        val artistName: String = intent?.extras?.getString(MainActivity.ARTIST_NAME_EXTRA) ?: ""
        val artistId: Int = intent?.extras?.getInt(MainActivity.ARTIST_ID_EXTRA) ?: 0
        title = artistName

        val albumList: List<Album> = listOf(
            Album("Album1", "20/01/1985", 20, "Rock"),
            Album("Album2", "20/01/1990", 10, "Rock"),
            Album("Album3", "20/01/1995", 15, "Rock"),
            Album("Album4", "20/01/2000", 12, "Rock"),
            Album("Album5", "20/01/2002", 16, "Rock"),
            Album("Album6", "20/01/2004", 4, "Rock"),
            Album("Album7", "20/01/2006", 4, "Rock"),
            Album("Album8", "20/01/2008", 6, "Rock"),
            Album("Album9", "20/01/2010", 7, "Rock"),
            Album("Album10", "20/01/2012", 12, "Rock"),
            Album("Album11", "20/01/2014", 11, "Rock"),
            Album("Album12", "20/01/2016", 3, "Rock"),
            Album("Album13", "20/01/2018", 9, "Rock")
        )
        val adapter = AlbumAdapter {
            toast(getString(R.string.label_number_of_track_in_album, it.name, it.trackCount.toString()))
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        getAlbumByArtistId(artistId)
    }

    private fun getAlbumByArtistId(id: Int) {
        Api.api.albumOfArtist(id).enqueue(object : Callback<ResponseWrapper<AlbumApi>> {
            override fun onFailure(call: Call<ResponseWrapper<AlbumApi>>, t: Throwable) {
                Log.d("TAG", "error")
            }

            override fun onResponse(
                call: Call<ResponseWrapper<AlbumApi>>,
                response: Response<ResponseWrapper<AlbumApi>>
            ) {
                if (response.isSuccessful) {
                    (recyclerView.adapter as AlbumAdapter).values = response.body()?.result?.filter { it.wrapperType == "collection" }?.map {
                        val album = it

                        Album(album.collectionName, album.date, album.trackCount, album.genreName)
                    } ?: ArrayList()
                }
            }
        })
    }

}