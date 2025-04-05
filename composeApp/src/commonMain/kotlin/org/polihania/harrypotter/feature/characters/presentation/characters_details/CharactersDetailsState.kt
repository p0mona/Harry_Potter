package org.polihania.harrypotter.feature.characters.presentation.characters_details

import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.characters.domain.model.CharacterModel

data class CharactersDetailsState(
    val character: Data<CharacterModel> = Data.Empty
)