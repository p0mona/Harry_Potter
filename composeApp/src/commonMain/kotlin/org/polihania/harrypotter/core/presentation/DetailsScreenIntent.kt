package org.polihania.harrypotter.core.presentation

sealed interface DetailsScreenIntent {

    data object UpdateDetailsData : DetailsScreenIntent
}
