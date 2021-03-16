package com.example.testebitrise.data.repository

import com.example.testebitrise.data.model.ComicResponse
import com.google.gson.annotations.SerializedName

data class ComicsDataResponse(
    @SerializedName("results") val comicsResultsList: List<ComicResponse>
)
