package discover

import androidx.compose.runtime.Composable
import discover.models.DiscoverButtonIcons
import discover.models.DiscoverButtonPanelModel
import discover.models.DiscoverViewState
import kotlin.random.Random.Default.nextInt

@Composable
fun DiscoverScreen() {
    DiscoverView(
        DiscoverViewState(
            DiscoverButtonPanelModel(
                buttonQuantity = 5,
                items = getMockkItems()
            )
        )
    )
}

private fun getMockkItems(): List<DiscoverButtonPanelModel.ParamsModel> {
    return listOf(
        DiscoverButtonPanelModel.ParamsModel(
            icon = DiscoverButtonIcons.Problems,
            durationMillis = nextInt(2000, 3500)
        ),
        DiscoverButtonPanelModel.ParamsModel(
            icon = DiscoverButtonIcons.Solutions,
            durationMillis = nextInt(2000, 3500)
        ),
        DiscoverButtonPanelModel.ParamsModel(
            icon = DiscoverButtonIcons.Projects,
            durationMillis = nextInt(2000, 3500)
        ),
        DiscoverButtonPanelModel.ParamsModel(
            icon = DiscoverButtonIcons.Enablers,
            durationMillis = nextInt(2000, 3500)
        ),
        DiscoverButtonPanelModel.ParamsModel(
            icon = DiscoverButtonIcons.Communities,
            durationMillis = nextInt(2000, 3500)
        )
    )
}
