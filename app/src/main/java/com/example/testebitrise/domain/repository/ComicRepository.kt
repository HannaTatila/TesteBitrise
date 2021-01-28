package com.example.testebitrise.domain.repository

import com.example.testebitrise.domain.model.Comic
import io.reactivex.Single

interface ComicRepository {

    fun get() : Single<List<Comic>>
    fun getById(idComic: Int) : Single<Comic>
}