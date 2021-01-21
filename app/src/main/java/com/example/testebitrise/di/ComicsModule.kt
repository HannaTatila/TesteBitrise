package com.example.testebitrise.di

import com.example.testebitrise.data.datasource.remote.ComicRemoteDataSource
import com.example.testebitrise.data.datasource.remote.ComicRemoteDataSourceImpl
import com.example.testebitrise.data.mappers.ComicMapper
import com.example.testebitrise.data.repository.ComicRepositoryImpl
import com.example.testebitrise.data.services.ComicService
import com.example.testebitrise.domain.repository.ComicRepository
import com.example.testebitrise.domain.usecase.GetComicUseCase
import com.example.testebitrise.domain.usecase.GetComicUseCaseImpl
import com.example.testebitrise.presentation.ListComicsViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ComicsModule {

//    private val gson: Gson by lazy { GsonBuilder().create() }
//
//    private val okHttp: OkHttpClient by lazy {
//        OkHttpClient.Builder()
//            .build()
//    }
//
//    private val retrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl("https://gateway.marvel.com/")
//            .client(okHttp)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//    }
//
//    private val comicsService: ComicService by lazy {
//        retrofit.create(ComicService::class.java)
//    }

//    private val logging = HttpLoggingInterceptor().apply {
//        this.level = HttpLoggingInterceptor.Level.BODY
//    }
//
//    var httpClient: OkHttpClient.Builder = OkHttpClient.Builder().apply {
//        this.addInterceptor(logging)
//    }
//
//    private val retrofit = Retrofit.Builder()
//        .baseUrl("https://gateway.marvel.com/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//        .client(httpClient.build())
//        .build()

//    private val comicsService = retrofit.create(ComicService::class.java)

//-----------------

//    private val url = "https://gateway.marvel.com/"
//
//    private val gson: Gson by lazy { GsonBuilder().create() }
//
//    private val okHttp: OkHttpClient by lazy {
//        OkHttpClient.Builder()
//            .build()
//    }
//
//    private val retrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(url)
//            .client(okHttp)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//    }
//
//    private val comicsService: ComicService by lazy {
//        retrofit.create(ComicService::class.java)
//    }

//    -------------

    private val url = "https://gateway.marvel.com/"

    private val gson: Gson by lazy { GsonBuilder().create() }

    private val okHttp: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(url)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private val comicsService: ComicService by lazy {
        retrofit.create(ComicService::class.java)
    }

    private val dataSource: ComicRemoteDataSource = ComicRemoteDataSourceImpl(comicsService)
    private val mapper: ComicMapper = ComicMapper()
    private val repository: ComicRepository = ComicRepositoryImpl(dataSource, mapper)
    private val useCase: GetComicUseCase = GetComicUseCaseImpl(repository)
    private val viewModel: ListComicsViewModel = ListComicsViewModel(useCase)

    val viewModelInstance = viewModel
}
