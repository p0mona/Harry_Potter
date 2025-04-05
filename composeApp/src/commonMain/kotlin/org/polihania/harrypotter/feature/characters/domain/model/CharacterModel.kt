package org.polihania.harrypotter.feature.characters.domain.model

data class CharacterModel(
    val birthDate: String,
    val children: List<String>,
    val fullName: String,
    val hogwartsHouse: String,
    val image: String,
    val index: Int,
    val interpretedBy: String,
    val nickname: String
)