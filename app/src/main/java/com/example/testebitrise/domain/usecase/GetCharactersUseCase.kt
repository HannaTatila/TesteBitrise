package com.example.testebitrise.domain.usecase

import com.example.testebitrise.domain.model.Characters
import io.reactivex.Single

interface GetCharactersUseCase {

    operator fun invoke(idComic: Int): Single<List<Characters>>
}
