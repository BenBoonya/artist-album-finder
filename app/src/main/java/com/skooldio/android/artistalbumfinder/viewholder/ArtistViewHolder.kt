package com.skooldio.android.artistalbumfinder.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.skooldio.android.artistalbumfinder.model.Artist
import kotlinx.android.synthetic.main.artist_viewholder.view.*

/**
 * Created by Boonya Kitpitak on 10/25/18.
 */
class ArtistViewHolder(view: View, itemClick: (Int) -> Unit) : RecyclerView.ViewHolder(view) {

    private val nameTextView = itemView.artistNameTextView
    private val genreTextView = itemView.genreTextView

    init {
        itemView.setOnClickListener {
            itemClick(adapterPosition)
        }
    }

    fun bindUi(artist: Artist) {
        nameTextView.text = artist.name
        genreTextView.text = artist.genre
    }

}