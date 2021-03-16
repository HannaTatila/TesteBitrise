package com.example.testebitrise.data.services

import com.example.testebitrise.data.repository.CharactersApiResponse
import com.example.testebitrise.data.repository.ComicsApiResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ComicService {

    @GET("/v1/public/comics?ts=1607023003&apikey=bceff44d5cdbeb2c5546ac39235d5cad&hash=d59edeba454582fe05ef2a126744eaa3")
    fun getComicsList(): Single<ComicsApiResponse>

    @GET("/v1/public/comics/{id}?ts=1607023003&apikey=bceff44d5cdbeb2c5546ac39235d5cad&hash=d59edeba454582fe05ef2a126744eaa3")
    fun getComic(@Path("id") id: Int): Single<ComicsApiResponse>

    @GET("/v1/public/comics/{id}/characters?ts=1607023003&apikey=bceff44d5cdbeb2c5546ac39235d5cad&hash=d59edeba454582fe05ef2a126744eaa3")
    fun getCharacters(@Path("id") id: Int): Single<CharactersApiResponse>

}
