package com.example.movie.db

import androidx.room.TypeConverter

object AppTypeConverters {

    @TypeConverter
    fun arrayStringToString(value: Array<String>?): String? {
        return value?.joinToString("|")
    }

    @TypeConverter
    fun stringToArrayString(value: String?): Array<String>? {
        return value?.split("|")?.toTypedArray()
    }
}