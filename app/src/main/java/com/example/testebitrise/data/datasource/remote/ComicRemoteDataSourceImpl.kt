package com.example.testebitrise.data.datasource.remote

import com.example.testebitrise.data.services.ComicService
import com.example.testebitrise.data.datasource.model.ComicResponse
import io.reactivex.Single

class ComicRemoteDataSourceImpl(private val comicService: ComicService) : ComicRemoteDataSource {

    override fun get(): Single<List<ComicResponse>> {
        return comicService.getComicsList()
            .onErrorResumeNext { throwable -> Single.error(throwable) }
            .map { it.comicsData.comicsResultsList }
    }
}
