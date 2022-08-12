package com.example.movieapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.api.MovieService
import com.example.movieapp.database.MovieDatabase
import com.example.movieapp.model.MovieList
import com.example.movieapp.utils.NetworkUtils

class MovieRepository(
    private val movieService: MovieService,
    private val movieDatabase: MovieDatabase,
    private val requireContext: Context,
) {

    private val moviesLiveData = MutableLiveData<MovieList>()

    val movies: LiveData<MovieList>
        get() = moviesLiveData

    suspend fun getPopularMovies(language: String, page: Int) {

        if (NetworkUtils.isInternetAvailable(requireContext)) {
            val result = movieService.getPopularMovies(language, page)
            if (result.body() != null) {
                movieDatabase.movieDao().insertMovies(result.body()!!.results)
                moviesLiveData.postValue(result.body())
            }
        } else {
            val movies = movieDatabase.movieDao().getPopularMovies()
            val movieList = MovieList(movies, 1, 1)
            moviesLiveData.postValue(movieList)
        }


    }

}










