package com.example.testebitrise.data.mappers

import com.example.testebitrise.data.model.ComicResponse
import com.example.testebitrise.domain.model.Comic

class ComicMapper {

    fun map(source: List<ComicResponse>): List<Comic> {
        return source.map { comicResponse ->
            Comic(
                comicResponse.id,
                comicResponse.title,
                comicResponse.description,
                comicResponse.releaseDateResponseList?.get(0)?.releaseDate
            )
        }
    }

    fun map(source: ComicResponse): Comic {
        return Comic(
            source.id,
            source.title,
            source.description,
            source.releaseDateResponseList?.get(0)?.releaseDate
        )
    }
}
