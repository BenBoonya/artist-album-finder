package com.skooldio.android.artistalbumfinder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ben.boonya.createApplicationScreenMessage
import kotlinx.android.synthetic.main.activity_multiplatform_demo.*

class MultiplatformDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplatform_demo)

        multiplatformTextView.text = createApplicationScreenMessage()
    }
}
