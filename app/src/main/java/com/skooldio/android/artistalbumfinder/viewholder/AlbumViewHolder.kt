package com.skooldio.android.artistalbumfinder.viewholder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.skooldio.android.artistalbumfinder.R
import com.skooldio.android.artistalbumfinder.model.Album
import kotlinx.android.synthetic.main.album_viewholder.view.*

/**
 * Created by Boonya Kitpitak on 10/27/18.
 */
class AlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val albumNameTextView = itemView.albumNameTexView
    private val trackCountTextView = itemView.trackCountTextView
    private val genreTextView = itemView.genreTextView
    private val releaseDateTextView = itemView.releaseDateTextView
    private val context: Context by lazy { itemView.context }

    fun bindUi(album: Album) {
        albumNameTextView.text = album.name
        trackCountTextView.text = context.getString(R.string.label_track_count, album.trackCount.toString())
        genreTextView.text = context.getString(R.string.label_primary_genre, album.primaryGenre)
        releaseDateTextView.text = context.getString(R.string.label_release_date, album.date)
    }
}