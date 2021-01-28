package com.example.testebitrise.presentation

import com.example.testebitrise.domain.model.Comic

data class ComicViewState(
    val isLoading: Boolean = false,
    val comic: Comic? = null
)
