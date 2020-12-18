package com.example.testebitrise.data.datasource.remote

import com.example.testebitrise.data.datasource.model.ComicResponse
import io.reactivex.Single

interface ComicRemoteDataSource {

    fun get(): Single<List<ComicResponse>>
}
