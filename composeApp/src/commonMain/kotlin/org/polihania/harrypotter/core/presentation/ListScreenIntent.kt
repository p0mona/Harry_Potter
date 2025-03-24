package org.polihania.harrypotter.core.presentation

sealed interface ListScreenIntent {

    data class OnItemClicked(val itemId: Int) : ListScreenIntent

    data object UpdateList : ListScreenIntent
}