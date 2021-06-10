package com.example.comicmarvels.data.repository

import com.example.comicmarvels.data.api.RetrofitInstance

class ComicRepository {

    suspend fun getComics() = RetrofitInstance.api.getComics()

}


