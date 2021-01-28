package com.example.testebitrise.di

import com.example.testebitrise.data.datasource.remote.ComicRemoteDataSource
import com.example.testebitrise.data.datasource.remote.ComicRemoteDataSourceImpl
import com.example.testebitrise.data.mappers.ComicMapper
import com.example.testebitrise.data.repository.ComicRepositoryImpl
import com.example.testebitrise.data.services.ComicService
import com.example.testebitrise.domain.repository.ComicRepository
import com.example.testebitrise.domain.usecase.GetComicByIdUseCase
import com.example.testebitrise.domain.usecase.GetComicByIdUseCaseImpl
import com.example.testebitrise.domain.usecase.GetComicUseCase
import com.example.testebitrise.domain.usecase.GetComicUseCaseImpl
import com.example.testebitrise.presentation.DetailsComicViewModel
import com.example.testebitrise.presentation.ListComicsViewModel
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ComicsModule {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()

    private val comicsService = retrofit.create(ComicService::class.java)
    private val dataSource: ComicRemoteDataSource = ComicRemoteDataSourceImpl(comicsService)
    private val mapper: ComicMapper = ComicMapper()
    private val repository: ComicRepository = ComicRepositoryImpl(dataSource, mapper)
    private val useCase: GetComicUseCase = GetComicUseCaseImpl(repository)
    private val viewModel: ListComicsViewModel = ListComicsViewModel(useCase)

    val viewModelInstance = viewModel

    private val useCaseDetails: GetComicByIdUseCase = GetComicByIdUseCaseImpl(repository)
    private val viewModelDetails: DetailsComicViewModel = DetailsComicViewModel(useCaseDetails)

    val viewModelDetailsInstance = viewModelDetails
}
