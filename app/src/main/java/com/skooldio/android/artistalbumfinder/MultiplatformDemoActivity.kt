package com.skooldio.android.artistalbumfinder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ben.boonya.createApplicationScreenMessage
import com.ben.boonya.network.MultiplatformApi
import kotlinx.android.synthetic.main.activity_multiplatform_demo.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MultiplatformDemoActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplatform_demo)

        val multiplatformApi = MultiplatformApi()
        multiplatformTextView.text = createApplicationScreenMessage()
        launch(Dispatchers.Main) {
            try {
                val result = withContext(Dispatchers.IO) { multiplatformApi.fetchArtist("slayer") }
                Toast.makeText(this@MultiplatformDemoActivity, result, Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(this@MultiplatformDemoActivity, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
