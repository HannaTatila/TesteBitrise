package com.example.testebitrise.domain.usecase

import com.example.testebitrise.domain.model.Comic
import io.reactivex.Single

interface GetComicByIdUseCase {

    operator fun invoke(idComic: Int): Single<Comic>
}
