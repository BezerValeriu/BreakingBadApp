package com.example.movie.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movie.repository.CharacterRepository


class CharacterListViewModelFactory(private val characterRepository: CharacterRepository) :
    ViewModelProvider.Factory {

    //    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(CharacterListViewModel::class.java)) {
//            return CharacterListViewModel(characterRepository) as T
//        }
//    }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
           return CharacterListViewModel(characterRepository) as T
       }
    }
