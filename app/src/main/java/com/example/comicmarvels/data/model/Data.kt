package com.example.comicmarvels.data.model

import com.google.gson.annotations.SerializedName

data class Data(
    val limit: Int,
    @SerializedName("results")
    val results: List<Comic>? = null
)