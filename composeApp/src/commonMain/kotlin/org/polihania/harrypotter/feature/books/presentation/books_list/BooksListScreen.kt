package org.polihania.harrypotter.feature.books.presentation.books_list


import androidx.compose.foundation.Image
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import harrypotter.composeapp.generated.resources.Res
import harrypotter.composeapp.generated.resources.character_item_description_title
import harrypotter.composeapp.generated.resources.character_item_label_title
import org.polihania.harrypotter.core.presentation.base.ListScreenIntent
import org.polihania.harrypotter.core.ui_kit.components.LazyColumnItem
import org.polihania.harrypotter.core.ui_kit.components.ListScreenContent
import org.jetbrains.compose.resources.stringResource

@Composable
fun BooksListScreen(
    state: BooksListState,
    onIntent: (ListScreenIntent) -> Unit,
) {
    ListScreenContent(
        data = state.books,
        onErrorButtonClick = { onIntent(ListScreenIntent.UpdateList) },
    ) { book ->
        LazyColumnItem(
            label = book.title,
            labelTitle = stringResource(resource = Res.string.character_item_label_title),
            description = book.releaseDate,
            descriptionTitle = stringResource(resource = Res.string.character_item_description_title),
            trailing = {
                val painter = rememberAsyncImagePainter(book.cover)
                val imageState by painter.state.collectAsState()

                when (imageState) {
                    is AsyncImagePainter.State.Empty,
                    is AsyncImagePainter.State.Loading -> {
                        CircularProgressIndicator()
                    }

                    is AsyncImagePainter.State.Success -> {
                        Image(
                            painter = painter,
                            contentDescription = null
                        )
                    }

                    is AsyncImagePainter.State.Error -> {
                        Text("Error loading image")
                    }
                }
            },
            onClick = { onIntent(ListScreenIntent.OnItemClicked(book.index)) }
        )
    }
}
