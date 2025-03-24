package org.polihania.harrypotter.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.compose.koinInject

@Composable
fun NavigationGraph(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val navigation: Navigation = koinInject()

    navigation.setNavigationController(navHostController)

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = BottomNavigationRoutes.BooksList
    ) {
        composable<BottomNavigationRoutes.BooksList> {
            // TODO
        }

        composable<DetailsRoutes.BooksDetails> {
            // TODO
        }

        composable<BottomNavigationRoutes.CharactersList> {
            // TODO
        }

        composable<DetailsRoutes.CharacterDetails> {
            // TODO
        }

        composable<BottomNavigationRoutes.HousesList> {
            // TODO
        }

        composable<BottomNavigationRoutes.SpellsList> {
            // TODO
        }
    }
}
