package com.example.testebitrise.data.repository

import com.example.testebitrise.data.datasource.remote.ComicRemoteDataSource
import com.example.testebitrise.data.mappers.CharacterMapper
import com.example.testebitrise.data.mappers.ComicMapper
import com.example.testebitrise.domain.model.Characters
import com.example.testebitrise.domain.model.Comic
import com.example.testebitrise.domain.repository.ComicRepository
import io.reactivex.Single

class ComicRepositoryImpl(
    private val comicRemoteDataSource: ComicRemoteDataSource,
    private val comicMapper: ComicMapper,
    private val characterMapper: CharacterMapper
) : ComicRepository {

    override fun get(): Single<List<Comic>> {
        return comicRemoteDataSource.get()
            .map { comicResponse ->
                comicMapper.map(comicResponse)
            }
    }

    override fun getById(idComic: Int): Single<Comic> {
        return comicRemoteDataSource.getById(idComic)
            .map { comicResponse ->
                comicMapper.map(comicResponse)
            }
    }

    override fun getCharacters(idComic: Int): Single<List<Characters>> {
        return comicRemoteDataSource.getCharacter(idComic)
            .map { characterResponse ->
                characterMapper.map(characterResponse)
            }
    }
}
