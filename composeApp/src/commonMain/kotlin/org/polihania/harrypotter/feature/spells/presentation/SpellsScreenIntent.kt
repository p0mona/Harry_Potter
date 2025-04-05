package org.polihania.harrypotter.feature.spells.presentation

sealed interface SpellsScreenIntent {

    data object UpdateList : SpellsScreenIntent
}