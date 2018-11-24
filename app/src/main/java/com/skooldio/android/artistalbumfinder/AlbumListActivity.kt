package com.skooldio.android.artistalbumfinder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.skooldio.android.artistalbumfinder.adapter.AlbumAdapter
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
            // TODO Change to string resource R.strings.label_number_of_track_in_album
            //getString(R.strings.label_number_of_track_in_album, album name, track number)
            toast(it.toString())
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@AlbumListActivity, LinearLayoutManager.VERTICAL, false)
            this.adapter = adapter
        }

        adapter.values = albumList
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