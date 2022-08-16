package com.example.movieapp.repository

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.movieapp.api.MovieService
import com.example.movieapp.database.MovieDatabase
import com.example.movieapp.model.MovieList
import com.example.movieapp.model.Result
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response


class MovieRepositoryTest {

    lateinit var movieRepository: MovieRepository

    @Mock
    lateinit var movieService: MovieService

    @Mock
    lateinit var movieDatabase: MovieDatabase
    private lateinit var context: Context

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        context = ApplicationProvider.getApplicationContext()
        movieRepository = MovieRepository(movieService,movieDatabase,context)
    }

    @Test
     fun returnPopularMoviesListFromNetworkCall() {
        runBlocking {
            Mockito.`when`(movieService.getPopularMovies("en_Us", 1))
                .thenReturn(Response.success(MovieList(listOf(Result("Thor",
                    "Thor movie",
                    234.90,
                    "22/09/1998",
                    4.9,
                    "hbjhw/ghjvghvw/hvxdhtyw",
                    0)), 1, 1)))
            val response = movieService.getPopularMovies("en-US",1)
                assertEquals(MovieList(listOf(Result("Thor",
                    "Thor movie",
                    234.90,
                    "22/09/1998",
                    4.9,
                    "hbjhw/ghjvghvw/hvxdhtyw",
                    0)), 1, 1), response.body())


        }
    }

//    @Test
//    fun returnPopularMoviesListFromDatabase() {
//
//    }

    @After
    fun tearDown() {

    }

}