package com.example.movieapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.model.Result

@Dao
interface MovieDao {

    @Query("SELECT * from movie")
    suspend fun getPopularMovies(): List<Result>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(results: List<Result>)
}