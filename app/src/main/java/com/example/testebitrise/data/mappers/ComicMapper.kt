package com.example.testebitrise.data.mappers

import com.example.testebitrise.data.datasource.model.ComicResponse
import com.example.testebitrise.domain.model.Comic

class ComicMapper {

    fun map(source: List<ComicResponse>): List<Comic> {
        return source.map { comicResponse ->
            Comic(
                comicResponse.id,
                comicResponse.title,
                comicResponse.description,
                comicResponse.releaseDateList?.get(0)?.releaseDate
            )
        }
    }
}
