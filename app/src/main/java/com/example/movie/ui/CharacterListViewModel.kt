package com.example.movie.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie.model.BBCharacter
import com.example.movie.repository.CharacterRepository
import kotlinx.coroutines.launch

class CharacterListViewModel (private val characterRepository: CharacterRepository) : ViewModel() {

    init {
        //refreshDataFromRepository()
    }

    private var _characterLivedata: MutableLiveData<List<BBCharacter>> = MutableLiveData(
        mutableListOf())
    val characterLivedata: LiveData<List<BBCharacter>> get() = _characterLivedata

    fun refreshDataFromRepository() {
        getData()
        viewModelScope.launch {
            characterRepository.refreshCharacters()
        }
    }

    fun getData() {
        viewModelScope.launch {
            characterRepository.characters.collect {
                it?.let {
                    _characterLivedata.postValue(it)
                }
            }
        }
    }

}



