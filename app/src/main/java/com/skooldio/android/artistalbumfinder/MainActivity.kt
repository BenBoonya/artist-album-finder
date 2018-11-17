package com.skooldio.android.artistalbumfinder

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.skooldio.android.artistalbumfinder.adapter.ArtistAdapter
import com.skooldio.android.artistalbumfinder.api.Api
import com.skooldio.android.artistalbumfinder.model.Artist
import com.skooldio.android.artistalbumfinder.model.ArtistApi
import com.skooldio.android.artistalbumfinder.model.ResponseWrapper
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

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

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        getArtistList("body")
    }

    private fun getArtistList(searchKey: String) {
        Api.api.searchForArtist(searchKey).enqueue(object : Callback<ResponseWrapper<ArtistApi>> {
            override fun onFailure(call: Call<ResponseWrapper<ArtistApi>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ResponseWrapper<ArtistApi>>,
                response: Response<ResponseWrapper<ArtistApi>>
            ) {
                if (response.isSuccessful) {
                    (recyclerView.adapter as ArtistAdapter).values =
                            response.body()?.result?.map { Artist(it.name, it.genreName, it.artistId.toInt()) } ?:
                            ArrayList()
                }
            }
        })
    }

    private fun navigateToAlbumList(artist: Artist) {
        val intent = Intent(this, AlbumListActivity::class.java)
        intent.putExtra(ARTIST_NAME_EXTRA, artist.name)
        intent.putExtra(ARTIST_ID_EXTRA, artist.id)
        startActivity(intent)
    }
}
