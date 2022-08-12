package com.example.movieapp.model


class MovieList(
    val results: List<Result>,
    val total_results: Int,
    val total_pages: Int,
) {
}