package com.skooldio.android.artistalbumfinder.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.skooldio.android.artistalbumfinder.model.Album
import com.skooldio.android.artistalbumfinder.viewholder.AlbumViewHolder

/**
 * Created by Boonya Kitpitak on 10/27/18.
 */
class AlbumAdapter : RecyclerView.Adapter<AlbumViewHolder>() {

    var values: List<Album> = ArrayList(0)
        set(value) {
            TODO("not implemented") //Set field and notify data set change
        }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): AlbumViewHolder {
        TODO("not implemented") //Create Album ViewHolder
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //Return number of item count
    }

    override fun onBindViewHolder(viewHolder: AlbumViewHolder, position: Int) {
        TODO("not implemented") //Bind data to ViewHolder
    }

}