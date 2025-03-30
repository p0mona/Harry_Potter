package org.polihania.harrypotter.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import org.polihania.harrypotter.feature.books.presentation.books_details.BooksDetailsScreen
import org.polihania.harrypotter.feature.books.presentation.books_details.BooksDetailsViewModel
import org.polihania.harrypotter.feature.books.presentation.books_list.BooksListScreen
import org.polihania.harrypotter.feature.books.presentation.books_list.BooksListViewModel

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
            val viewModel: BooksListViewModel = koinViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            BooksListScreen(
                state = state,
                onIntent = viewModel::handleIntent
            )

        }

        composable<DetailsRoutes.BooksDetails> {
            val id = it.toRoute<DetailsRoutes.BooksDetails>().bookId
            val viewModel: BooksDetailsViewModel = koinViewModel { parametersOf(id) }
            val state by viewModel.state.collectAsStateWithLifecycle()

            BooksDetailsScreen(
                state = state,
                onIntent = viewModel::handleIntent
            )
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
