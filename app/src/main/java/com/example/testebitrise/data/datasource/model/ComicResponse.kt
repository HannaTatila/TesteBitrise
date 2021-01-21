package com.example.testebitrise.data.datasource.model

import com.example.testebitrise.data.repository.ReleaseDate
import com.google.gson.annotations.SerializedName

data class ComicResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("dates") val releaseDateList: List<ReleaseDate>? = null
)
