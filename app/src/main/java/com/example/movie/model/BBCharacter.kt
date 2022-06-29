package com.example.movie.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "character")
data class BBCharacter (
    @PrimaryKey
    @SerializedName("char_id")
    val id: Int,
    val name: String,
    val birthday: String,
    val img: String?,
    val nickname: String,
    val status: String
):Serializable
