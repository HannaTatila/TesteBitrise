package com.example.testebitrise.domain.usecase

import com.example.testebitrise.domain.model.Comic
import com.example.testebitrise.domain.repository.ComicRepository
import io.reactivex.Single

class GetComicUseCaseImpl(private val repository: ComicRepository) : GetComicUseCase{

    override fun invoke(): Single<List<Comic>> {
        return repository.get()
    }
}