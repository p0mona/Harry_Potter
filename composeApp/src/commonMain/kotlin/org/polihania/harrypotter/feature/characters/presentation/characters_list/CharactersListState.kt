package org.polihania.harrypotter.feature.characters.presentation.characters_list

import androidx.compose.runtime.Stable
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.characters.domain.model.CharacterModel

@Stable
data class CharactersListState(
    val characters: Data<List<CharacterModel>> = Data.Empty,
)