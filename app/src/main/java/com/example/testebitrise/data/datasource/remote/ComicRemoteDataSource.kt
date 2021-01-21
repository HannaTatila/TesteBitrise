package com.example.testebitrise.data.datasource.remote

import com.example.testebitrise.data.datasource.model.ComicResponse
import com.example.testebitrise.data.repository.ComicsApiResponse
import io.reactivex.Single
import retrofit2.Call

interface ComicRemoteDataSource {

    fun get(): Single<List<ComicResponse>>
}
