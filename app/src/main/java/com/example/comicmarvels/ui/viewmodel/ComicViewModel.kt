package com.example.comicmarvels.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comicmarvels.data.model.ComicResponse
import com.example.comicmarvels.data.repository.ComicRepository
import com.example.comicmarvels.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class ComicViewModel(
    val comicRepository: ComicRepository
):ViewModel(){

    val comics: MutableLiveData<Resource<ComicResponse>> = MutableLiveData()

    init {
        getComics()
    }
    fun getComics() = viewModelScope.launch {
        comics.postValue(Resource.Loading())
        val response = comicRepository.getComics()
         comics.postValue(handleResponse(response))
    }

    private fun handleResponse(response: Response<ComicResponse>): Resource<ComicResponse>{
        if (response.isSuccessful){
           response.body()?.let { resultResponse ->
               return Resource.Success(resultResponse)
           }
        }
        return Resource.Error(response.message())
    }

}