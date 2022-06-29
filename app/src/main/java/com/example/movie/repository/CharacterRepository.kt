package com.example.movie.repository

import androidx.lifecycle.LiveData
import com.example.movie.db.CharacterDao
import com.example.movie.model.BBCharacter
import com.example.movie.service.BreakingBadNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class CharacterRepository() {

    private var _chars= MutableStateFlow<List<BBCharacter>>(mutableListOf())
    val characters: StateFlow<List<BBCharacter>> get() = _chars

    suspend fun refreshCharacters(){
        withContext(Dispatchers.IO){
            val response =  BreakingBadNetwork.service.getCharacters()
            if(response.isSuccessful){
                _chars.value= response.body()!!
            }
        }
    }
}