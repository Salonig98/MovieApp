package com.example.movieapp.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.movieapp.repository.MovieRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    lateinit var movieRepository: MovieRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test()
    fun getAllPopularMovie() {}

}