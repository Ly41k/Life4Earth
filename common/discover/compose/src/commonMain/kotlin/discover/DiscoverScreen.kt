package discover

import androidx.compose.runtime.Composable
import discover.models.DiscoverButtonIcons
import discover.models.DiscoverButtonPanelModel
import discover.models.DiscoverViewState

@Composable
fun DiscoverScreen() {
    DiscoverView(
        DiscoverViewState(
            DiscoverButtonPanelModel(
                buttonQuantity = 5,
                items = getItems()
            )
        )
    )
}

private fun getItems(): List<DiscoverButtonPanelModel.ParamsModel> {
    return listOf(
        DiscoverButtonPanelModel.ParamsModel(
            icon = DiscoverButtonIcons.Problems,
            durationMillis = 3500
        ),
        DiscoverButtonPanelModel.ParamsModel(
            icon = DiscoverButtonIcons.Solutions,
            durationMillis = 3500
        ),
        DiscoverButtonPanelModel.ParamsModel(
            icon = DiscoverButtonIcons.Projects,
            durationMillis = 3500
        ),
        DiscoverButtonPanelModel.ParamsModel(
            icon = DiscoverButtonIcons.Enablers,
            durationMillis = 3500
        ),
        DiscoverButtonPanelModel.ParamsModel(
            icon = DiscoverButtonIcons.Communities,
            durationMillis = 3500
        )
    )
}
