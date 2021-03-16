package com.example.testebitrise.data.repository

import com.example.testebitrise.data.model.CharacterResponse
import com.google.gson.annotations.SerializedName

data class CharactersDataResponse(
    @SerializedName("results") val characterResultsList: List<CharacterResponse>
)
