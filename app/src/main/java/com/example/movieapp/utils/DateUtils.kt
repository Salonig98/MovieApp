package com.example.movieapp.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateUtils {

    companion object {
        fun stringToDateConversion(date: String): String {

            val dtStart = date
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            try {
                val date: Date = format.parse(dtStart)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return date
        }
    }
}