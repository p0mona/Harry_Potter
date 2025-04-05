package org.polihania.harrypotter.feature.characters.data.dto

import kotlinx.serialization.Serializable
import org.polihania.harrypotter.core.utils.orZero
import org.polihania.harrypotter.feature.characters.domain.model.CharacterModel

@Serializable
data class CharacterDto(
    val birthdate: String? = null,
    val children: List<String?>? = null,
    val fullName: String? = null,
    val hogwartsHouse: String? = null,
    val image: String? = null,
    val index: Int? = null,
    val interpretedBy: String? = null,
    val nickname: String? = null
)

fun CharacterDto.toModel() = CharacterModel(
    index = index.orZero(),
    birthDate = birthdate.orEmpty(),
    children = children?.mapNotNull { it }.orEmpty(),
    fullName = fullName.orEmpty(),
    hogwartsHouse = hogwartsHouse.orEmpty(),
    image = image.orEmpty(),
    interpretedBy = interpretedBy.orEmpty(),
    nickname = nickname.orEmpty()
)

fun List<CharacterDto>.toModelList() = map { it.toModel() }