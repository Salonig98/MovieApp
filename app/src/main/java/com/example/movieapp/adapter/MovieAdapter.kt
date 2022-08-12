package com.example.movieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.model.Result


const val IMAGE_BACKDROP_PATH = "https://image.tmdb.org/t/p/w500"

class MovieAdapter(
    private val context: Context,
    private val movieItemClickInterface: MovieClickInterface,
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var allResultList = mutableListOf<Result>()

    fun setMovieList(results: List<Result>) {
        this.allResultList = results.toMutableList()
        notifyDataSetChanged()
    }

    interface MovieClickInterface {
        fun onMovieClick(result: Result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_rv_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = allResultList[position]
        holder.titleTV.text = movie.title
        holder.overViewTV.text = movie.overview
        Glide.with(holder.moviePosterIV.context)
            .load(IMAGE_BACKDROP_PATH + movie.poster_path)
            .into(holder.moviePosterIV);

        holder.itemView.setOnClickListener {
            movieItemClickInterface.onMovieClick(allResultList[position])
        }
    }

    override fun getItemCount(): Int {
        return allResultList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTV: TextView = itemView.findViewById(R.id.id_tv_movie_title)
        val overViewTV: TextView = itemView.findViewById(R.id.id_tv_movie_description)
        var moviePosterIV: ImageView = itemView.findViewById(R.id.id_iv_movie_poster)
    }

}