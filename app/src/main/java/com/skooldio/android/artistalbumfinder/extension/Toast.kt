package com.skooldio.android.artistalbumfinder.extension

import android.app.Activity
import android.widget.Toast

/**
 * Created by Boonya Kitpitak on 10/27/18.
 */
fun Activity.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}