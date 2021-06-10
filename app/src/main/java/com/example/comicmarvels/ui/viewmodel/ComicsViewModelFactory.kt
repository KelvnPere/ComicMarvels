package com.example.comicmarvels.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.comicmarvels.data.repository.ComicRepository

class ComicsViewModelFactory(
    val comicRepository: ComicRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ComicViewModel(comicRepository) as T
    }
}