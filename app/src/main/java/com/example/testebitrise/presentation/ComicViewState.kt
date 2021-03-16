package com.example.testebitrise.presentation

import com.example.testebitrise.domain.model.Characters
import com.example.testebitrise.domain.model.Comic

data class ComicViewState(
    val isLoading: Boolean = false,
    val comic: Comic? = null,
    val characters: List<Characters> = listOf()
)
