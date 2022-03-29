package com.sample.brazepoc

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentActivity

class MovieDetailsActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        intent.extras?.let {
            populate(it)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.extras?.let {
            populate(it)
        }
    }

    private fun populate(it: Bundle) {
        val title = findViewById<TextView>(R.id.title)
        val desc = findViewById<TextView>(R.id.description)
        title.text = it.getString("title")
        desc.text = it.getString("desc")
    }

    companion object {
        const val SHARED_ELEMENT_NAME = "hero"
        const val MOVIE = "Movie"
    }
}