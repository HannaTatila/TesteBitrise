package com.example.testebitrise.domain.usecase

import com.example.testebitrise.data.repository.ComicsApiResponse
import com.example.testebitrise.domain.model.Comic
import io.reactivex.Single
import retrofit2.Call

interface GetComicUseCase {

    operator fun invoke() : Single<List<Comic>>
}