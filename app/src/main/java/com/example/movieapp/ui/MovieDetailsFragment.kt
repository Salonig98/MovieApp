package com.example.movieapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.FragmentMovieDetailsBinding
import com.example.movieapp.utils.DateUtils


class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding
    private val args: MovieDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        setUpToolbar()
        setDataInUi()
        return binding.root
    }

    private fun setUpToolbar() {
        val toolbar: Toolbar = binding.toolbar
        toolbar.title = args.movie.title
        toolbar.setNavigationOnClickListener {
            val action =
                MovieDetailsFragmentDirections.actionMovieDetailsFragmentToMovieListFragment()
            findNavController().navigate(action)
        }
    }

    private fun setDataInUi() {
        binding.tvPopularityValue.text = args.movie.popularity.toString()
        binding.tvRatingValue.text = args.movie.rating.toString()
        binding.tvOverviewValue.text = args.movie.overview
        binding.tvReleaseDateValue.text =
            DateUtils.stringToDateConversion(args.movie.release_date)
        Glide.with(this)
            .load(com.example.movieapp.adapter.IMAGE_BACKDROP_PATH + args.movie.poster_path)
            .into(binding.moviePoster)
    }

}