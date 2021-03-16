package com.example.testebitrise.data.mappers

import com.example.testebitrise.data.model.CharacterResponse
import com.example.testebitrise.domain.model.Characters

class CharacterMapper {

    fun map(source: List<CharacterResponse>): List<Characters> {
        return source.map { characterResponse ->
            Characters(
                characterResponse.id,
                characterResponse.name
            )
        }
    }
}
