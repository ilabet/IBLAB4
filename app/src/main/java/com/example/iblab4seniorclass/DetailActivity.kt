package com.example.iblab4seniorclass

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


private val Unit.activity_detail: Any
    get() {
        TODO()
    }

class DetailActivity : AppCompatActivity() {
    private lateinit var campgroundNameTV: TextView
    private lateinit var campgroundDescriptionTV: TextView
    private lateinit var campgroundLatLongTV: TextView
    private lateinit var campgroundImageIV: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentView = setContentView(R.layout.activity_detail)

        campgroundNameTV = findViewById(R.id.campgroundName)
        campgroundDescriptionTV = findViewById(R.id.campgroundDescription)
        campgroundLatLongTV = findViewById(R.id.campgroundLocation)
        campgroundImageIV = findViewById(R.id.campgroundImage)

        val campground = intent.getSerializableExtra(CAMPGROUND_EXTRA) as Campground

        campgroundNameTV.text = campground.name
        campgroundDescriptionTV.text = campground.description
        campgroundLatLongTV.text = campground.latLong

        Glide.with(this)
            .load(campground.imageUrl)
            .into(campgroundImageIV)
    }
}
