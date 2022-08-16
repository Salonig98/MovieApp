package com.example.movieapp.retrofitServiceTest

import com.example.movieapp.api.API_KEY
import com.example.movieapp.api.MovieService
import com.google.gson.Gson
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieServiceTest  {

    lateinit var mockWebServer: MockWebServer
    lateinit var movieService: MovieService
    lateinit var gson: Gson

    @Before
     fun setUp() {
        MockitoAnnotations.initMocks(this)
        gson = Gson()
        mockWebServer = MockWebServer()
        movieService =
            Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/movie/").addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(MovieService::class.java)

    }

    @Test
    fun getAllMovieApiTest() {
        runBlocking {
            val mockResponse = MockResponse()
            mockWebServer.enqueue(mockResponse.setBody("[]"))
            val response = movieService.getPopularMovies("en-US",1)
            val request = mockWebServer.takeRequest()
            assertEquals("popular?api_key=$API_KEY",request.path)
            assertEquals(true, response.body()?.results?.isEmpty() ?: true)
        }
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

}