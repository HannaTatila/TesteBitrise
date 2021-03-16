package com.example.testebitrise.data.datasource.remote

import com.example.testebitrise.data.model.CharacterResponse
import com.example.testebitrise.data.model.ComicResponse
import io.reactivex.Single

interface ComicRemoteDataSource {

    fun get(): Single<List<ComicResponse>>
    fun getById(idComic: Int): Single<ComicResponse>
    fun getCharacter(idComic: Int): Single<List<CharacterResponse>>
}
