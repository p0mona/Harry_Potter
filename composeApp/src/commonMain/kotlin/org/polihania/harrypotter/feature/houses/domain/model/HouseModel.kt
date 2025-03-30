package org.polihania.harrypotter.feature.houses.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class HouseModel(
    val animal: String,
    val colors: List<String>,
    val emoji: String,
    val founder: String,
    val houseName: String,
    val index: Int
)