package com.example.testebitrise.domain.usecase

import com.example.testebitrise.domain.model.Characters
import com.example.testebitrise.domain.repository.ComicRepository
import io.reactivex.Single

class GetCharactersUseCaseImpl(private val repository: ComicRepository) : GetCharactersUseCase {

    override fun invoke(idComic: Int): Single<List<Characters>> {
        return repository.getCharacters(idComic)
    }
}