package com.example.movieapp.database

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.movieapp.dao.MovieDao
import com.example.movieapp.model.Result
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class MovieDatabaseTest {

    private lateinit var movieDao: MovieDao
    private lateinit var db: MovieDatabase

    @Before
   fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, MovieDatabase::class.java).build()
        movieDao = db.movieDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadMovie() = runBlocking {
        val result1 = Result("Thor",
            "SuperHero marvel movie",
            234.98,
            "23/09/2022",
            6.7,
            "https://lumiere-a.akamaihd.net/v1/images/p_thorloveandthunder_22808_89cd85bd.jpeg",
            )
        val result2 = Result("Thor 2",
            "SuperHero marvel movie",
            234.98,
            "23/09/2022",
            6.7,
            "https://lumiere-a.akamaihd.net/v1/images/p_thorloveandthunder_22808_89cd85bd.jpeg",
            )
        val result3 = Result("Thor 3",
            "SuperHero marvel movie",
            234.98,
            "23/09/2022",
            6.7,
            "https://lumiere-a.akamaihd.net/v1/images/p_thorloveandthunder_22808_89cd85bd.jpeg",
            )

        val movieList: List<Result> = listOf(result1, result2, result3)
        movieDao.insertMovies(movieList)
        val resultList: List<Result> = movieDao.getPopularMovies()

        //assertTrue(movieList.size == resultList.size && movieList.containsAll(resultList) && resultList.containsAll(movieList));
        //Assert.assertEquals(resultList,movieList)
        //assertNotEquals("these are the not same",resultList.containsAll(movieList) && movieList.containsAll(resultList))
        assertEquals(movieList.toTypedArray().size,resultList.toTypedArray().size);
    }

}


