package com.skooldio.android.artistalbumfinder.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.skooldio.android.artistalbumfinder.R
import com.skooldio.android.artistalbumfinder.model.Album
import com.skooldio.android.artistalbumfinder.viewholder.AlbumViewHolder

/**
 * Created by Boonya Kitpitak on 10/27/18.
 */
class AlbumAdapter(
        //TODO Change param type of Lambda
        private val itemClick: (Int) -> Unit) : RecyclerView.Adapter<AlbumViewHolder>() {

    var values: List<Album> = ArrayList(0)
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): AlbumViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.album_viewholder, parent, false)
        return AlbumViewHolder(viewHolder) {
            //TODO Change param of lambda from position to Album
            itemClick(it)
        }
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(viewHolder: AlbumViewHolder, position: Int) {
        viewHolder.bindUi(values[position])
    }

}