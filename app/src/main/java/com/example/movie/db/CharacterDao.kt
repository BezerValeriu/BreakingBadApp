package com.example.movie.db
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movie.model.BBCharacter

@Dao
interface CharacterDao {
    @Query("select * from character")
    fun findall(): List<BBCharacter>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characterList: List<BBCharacter>)
}