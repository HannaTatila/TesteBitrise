package com.example.testebitrise.domain.usecase

import com.example.testebitrise.domain.model.Comic
import com.example.testebitrise.domain.repository.ComicRepository
import io.reactivex.Single

class GetComicByIdUseCaseImpl(private val repository: ComicRepository)  : GetComicByIdUseCase {

    override fun invoke(idComic: Int): Single<Comic> {
        return repository.getById(idComic)
    }
}
