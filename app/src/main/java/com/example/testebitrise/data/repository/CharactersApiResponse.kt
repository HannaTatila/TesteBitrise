package com.example.testebitrise.data.repository

import com.google.gson.annotations.SerializedName

data class CharactersApiResponse(
    @SerializedName("data") val charactersData: CharactersDataResponse
)
