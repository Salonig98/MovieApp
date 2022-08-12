package com.example.movieapp.api

import com.example.movieapp.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "38a73d59546aa378980a88b645f487fc"

interface MovieService {

    @GET("popular?api_key=$API_KEY")
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): Response<MovieList>

    //baseUrl + /now playing + ?language + ?page
}