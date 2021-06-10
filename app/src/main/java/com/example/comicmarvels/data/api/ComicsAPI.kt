package com.example.comicmarvels.data.api

import com.example.comicmarvels.data.model.ComicResponse
import com.example.comicmarvels.utils.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ComicsAPI {

    @GET("comics")
    suspend fun getComics(
        @Query("ts") apiKey: String = Constant.ts,
        @Query("apikey") ts: String = Constant.API_KEY,
        @Query("hash") hash: String = Constant.hash(),
        @Query("limit") limit: String = Constant.limit
    ):Response<ComicResponse>
}