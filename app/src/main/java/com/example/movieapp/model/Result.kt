package com.example.movieapp.model

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide
import com.example.movieapp.adapter.IMAGE_BACKDROP_PATH
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "movie")
@Parcelize
class Result(

    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "popularity") val popularity: Double,
    @ColumnInfo(name = "release_date") val release_date: String,
    @ColumnInfo(name = "rating") val rating: Double,
    @ColumnInfo(name = "poster_path") val poster_path: String,
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Int = 0,
) : Parcelable
