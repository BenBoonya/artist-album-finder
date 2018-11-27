package com.skooldio.android.artistalbumfinder.extension

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Boonya Kitpitak on 11/27/18.
 */
inline fun <T> retrofit2.Call<T>.enqueue(
    crossinline successHandler: (T?) -> Unit,
    crossinline failureHandler: (Any) -> Unit
) =
    enqueue(object : Callback<T> {

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            response?.let {
                if (it.isSuccessful) {
                    successHandler(it.body())
                } else {
                    failureHandler(Any())
                }
            } ?: run {
                failureHandler(Any())
            }
        }

        override fun onFailure(call: Call<T>?, t: Throwable?) {
            failureHandler(Any())
        }
    })