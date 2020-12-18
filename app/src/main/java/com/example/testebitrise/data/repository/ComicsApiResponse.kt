package com.example.testebitrise.data.repository

import com.google.gson.annotations.SerializedName

data class ComicsApiResponse(
    @SerializedName("data") val comicsData: ComicsDataResponse
)
