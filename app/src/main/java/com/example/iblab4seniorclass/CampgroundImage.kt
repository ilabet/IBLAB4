package com.example.iblab4seniorclass

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



const val CAMPGROUND_EXTRA = "CAMPGROUND_EXTRA"

class CampgroundAdapter(
    private val context: Context,
    private val campgrounds: List<Campground>
) : RecyclerView.Adapter<CampgroundAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val nameTextView: TextView = itemView.findViewById(R.id.campgroundName)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.campgroundDescription)
        private val locationTextView: TextView = itemView.findViewById(R.id.campgroundLocation)
        private val imageView: ImageView = itemView.findViewById(R.id.campgroundImage)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(campground: Campground) {
            nameTextView.text = campground.name ?: ""
            descriptionTextView.text = campground.description ?: ""
            locationTextView.text = campground.latLong ?: ""

            Glide.with(itemView.context)
                .load(campground.imageUrl)
                .into(imageView)
        }

        override fun onClick(v: View?) {
            val campground = campgrounds[absoluteAdapterPosition]
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra(CAMPGROUND_EXTRA, campground)
            itemView.context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_campground, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(campgrounds[position])
    }

    override fun getItemCount(): Int = campgrounds.size
}
