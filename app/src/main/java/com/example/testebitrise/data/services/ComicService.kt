package com.example.testebitrise.data.services

import com.example.testebitrise.data.repository.ComicsApiResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ComicService {

    @GET("/v1/public/comics?ts=1607023003&apikey=bceff44d5cdbeb2c5546ac39235d5cad&hash=d59edeba454582fe05ef2a126744eaa3")
    fun getComicsList(): Single<ComicsApiResponse>

//    @GET("/comics/{id}?ts=1607023003&apikey=bceff44d5cdbeb2c5546ac39235d5cad&hash=d59edeba454582fe05ef2a126744eaa3")
//    fun getComic(@Path("id") id: Int): Single<ComicResponse>


//    fun getListComics(): Single<List<ComicResponse>> {
//        val comicList = listOf(
//            ComicResponse(
//                0,
//                "Title 1",
//                "Description 1",
//                "Date 01/01/1111"
//            ),
//            ComicResponse(
//                1,
//                "Title 2",
//                "Description 2",
//                "Date 02/02/2222"
//            ),
//            ComicResponse(
//                2,
//                "Title 3",
//                "Description 3",
//                "Date 03/03/3333"
//            )
//        )
//
//        return Single.create { emitter ->
//            emitter.onSuccess(comicList)
//        }
//    }
}
