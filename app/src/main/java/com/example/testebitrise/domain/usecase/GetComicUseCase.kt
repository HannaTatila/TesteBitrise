package com.example.testebitrise.domain.usecase

import com.example.testebitrise.domain.model.Comic
import io.reactivex.Single

interface GetComicUseCase {

    operator fun invoke() : Single<List<Comic>>
}