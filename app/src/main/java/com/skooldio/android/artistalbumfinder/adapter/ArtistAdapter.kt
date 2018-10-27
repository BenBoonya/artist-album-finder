package com.skooldio.android.artistalbumfinder.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.skooldio.android.artistalbumfinder.R
import com.skooldio.android.artistalbumfinder.model.Artist
import com.skooldio.android.artistalbumfinder.viewholder.ArtistViewHolder

/**
 * Created by Boonya Kitpitak on 10/25/18.
 */
class ArtistAdapter(private val itemClick: (Artist) -> Unit) : RecyclerView.Adapter<ArtistViewHolder>() {

    var values: List<Artist> = ArrayList(0)
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ArtistViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.artist_viewholder, parent, false)
        return ArtistViewHolder(viewHolder) {
            itemClick(values[it])
        }
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(viewHolder: ArtistViewHolder, position: Int) {
        viewHolder.bindUi(values[position])
    }

}