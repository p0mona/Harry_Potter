package org.polihania.harrypotter.feature.books.presentation.books_details


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import harrypotter.composeapp.generated.resources.Res
import harrypotter.composeapp.generated.resources.book_details_number
import harrypotter.composeapp.generated.resources.book_details_pages
import harrypotter.composeapp.generated.resources.book_details_releaseDate
import org.polihania.harrypotter.core.presentation.base.DetailsScreenIntent
import org.polihania.harrypotter.core.ui_kit.components.DetailsScreenContent
import org.jetbrains.compose.resources.stringResource
import org.polihania.harrypotter.core.ui_kit.components.PotterText

@Composable
fun BooksDetailsScreen(
    state: BooksDetailsState,
    onIntent: (DetailsScreenIntent) -> Unit,
) {
    DetailsScreenContent(
        data = state.book,
        onErrorButtonClick = { onIntent(DetailsScreenIntent.UpdateDetailsData) },
        content = { bookDetails ->
            val painter = rememberAsyncImagePainter(bookDetails.cover)
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

                is AsyncImagePainter.State.Error -> {}
            }

            PotterText(
                modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                text = bookDetails.title,
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                text = bookDetails.description,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )

            Row(
                Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(resource = Res.string.book_details_number),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = bookDetails.number.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Row(
                Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(resource = Res.string.book_details_releaseDate),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = bookDetails.releaseDate,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Row(
                Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(resource = Res.string.book_details_pages),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = bookDetails.pages.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    )
}
