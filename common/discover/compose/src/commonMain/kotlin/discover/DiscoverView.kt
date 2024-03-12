package discover

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.theme.Life4EarthTheme
import compose.widgets.TopAppBarView
import discover.models.DiscoverViewState

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun DiscoverView(state: DiscoverViewState) {
    Scaffold(
        topBar = { TopAppBarView { } },
        backgroundColor = Life4EarthTheme.colors.primaryBackground
    ) {
        BoxWithConstraints {
            Box(modifier = Modifier.fillMaxSize()) {
                StellarSkyView(modifier = Modifier.fillMaxSize())
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    EarthView()
                    Spacer(modifier = Modifier.weight(1f))
                    DiscoverButtonPanelView(
                        modifier = Modifier.padding(bottom = 20.dp),
                        buttonQuantity = state.discoverButtonPanelModel.buttonQuantity,
                        paramsModels = state.discoverButtonPanelModel.items
                    )
                }
            }
        }
    }
}
