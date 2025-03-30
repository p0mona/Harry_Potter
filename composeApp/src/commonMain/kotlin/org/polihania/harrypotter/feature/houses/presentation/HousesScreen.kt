package org.polihania.harrypotter.feature.houses.presentation


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import harrypotter.composeapp.generated.resources.Res
import harrypotter.composeapp.generated.resources.house_item_description_title
import harrypotter.composeapp.generated.resources.house_item_label_title
import org.jetbrains.compose.resources.stringResource
import org.polihania.harrypotter.core.ui_kit.components.LazyColumnItem
import org.polihania.harrypotter.core.ui_kit.components.ListScreenContent

@Composable
fun HousesScreen(
    state: HousesState,
    onIntent: (HousesScreenIntent) -> Unit,
) {
    ListScreenContent(
        data = state.houses,
        onErrorButtonClick = { onIntent(HousesScreenIntent.UpdateList) },
    ) { house ->
        LazyColumnItem(
            label = house.houseName,
            labelTitle = stringResource(resource = Res.string.house_item_label_title),
            description = house.founder,
            descriptionTitle = stringResource(resource = Res.string.house_item_description_title),
            trailing = {
                Text(
                    text = house.emoji,
                    style = MaterialTheme.typography.displayLarge
                )
            }
        )
    }
}
