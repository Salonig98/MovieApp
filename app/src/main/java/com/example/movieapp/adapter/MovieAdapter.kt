package com.example.movieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.MovieRvItemBinding
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
        val inflater = LayoutInflater.from(context)
        val binding = MovieRvItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(allResultList[position])
    }

    override fun getItemCount(): Int {
        return allResultList.size
    }

    inner class ViewHolder(private val binding: MovieRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Result) {
            binding.result = item
            binding.executePendingBindings()
            binding.cardMovie.setOnClickListener {
                movieItemClickInterface.onMovieClick(item)
            }
        }
    }
}