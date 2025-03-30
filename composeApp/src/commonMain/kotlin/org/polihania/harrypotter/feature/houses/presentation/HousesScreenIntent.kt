package org.polihania.harrypotter.feature.houses.presentation

sealed interface HousesScreenIntent {

    data object UpdateList : HousesScreenIntent
}