package com.example.testebitrise.presentation

import com.example.testebitrise.domain.model.Comic

data class ComicsViewState(
    val isLoading: Boolean = false,
    val comicsList: List<Comic> = listOf()
)
