package com.example.testebitrise.data.datasource.remote

import com.example.testebitrise.data.model.CharacterResponse
import com.example.testebitrise.data.services.ComicService
import com.example.testebitrise.data.model.ComicResponse
import io.reactivex.Single

class ComicRemoteDataSourceImpl(private val comicService: ComicService) : ComicRemoteDataSource {

    override fun get(): Single<List<ComicResponse>> {
        return comicService.getComicsList()
            .onErrorResumeNext { throwable -> Single.error(throwable) }
            .map { it.comicsData.comicsResultsList }
    }

    override fun getById(idComic: Int): Single<ComicResponse> {
        return comicService.getComic(idComic)
            .map { it.comicsData.comicsResultsList[0] }
    }

    override fun getCharacter(idComic: Int): Single<List<CharacterResponse>> {
        return comicService.getCharacters(idComic)
            .map { it.charactersData.characterResultsList }
    }
}
