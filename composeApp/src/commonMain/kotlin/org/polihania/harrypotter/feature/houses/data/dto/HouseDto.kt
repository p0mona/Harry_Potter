package org.polihania.harrypotter.feature.houses.data.dto

import kotlinx.serialization.Serializable
import org.polihania.harrypotter.core.utils.orZero
import org.polihania.harrypotter.feature.houses.domain.model.HouseModel

@Serializable
class HouseDto(
    val animal: String? = null,
    val colors: List<String?>? = null,
    val emoji: String? = null,
    val founder: String? = null,
    val house: String? = null,
    val index: Int? = null
)

fun HouseDto.toModel() = HouseModel(
    index = index.orZero(),
    animal = animal.orEmpty(),
    colors = colors.orEmpty().filterNotNull(),
    emoji = emoji.orEmpty(),
    founder = founder.orEmpty(),
    houseName = house.orEmpty(),
)

fun List<HouseDto>.toModelList() = map { it.toModel() }
