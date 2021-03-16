package com.example.testebitrise.data.repository

import com.google.gson.annotations.SerializedName

data class ReleaseDateResponse(
    @SerializedName("type") val type: String? = null,
    @SerializedName("date") val releaseDate: String? = null
)
