package navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import compose.theme.Life4EarthTheme
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun BookmarkNavGraph() {
    val navigator = rememberNavigator()
    NavHost(
        navigator = navigator,
        initialRoute = DiscoverNavigation.Discover.route,
    ) {
        scene(route = DiscoverNavigation.Discover.route) {
            Column(
                modifier = Modifier.fillMaxSize().background(Life4EarthTheme.colors.primaryBackground),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "BookmarkTab",
                    color = Life4EarthTheme.colors.primaryText,
                    style = Life4EarthTheme.typography.mediumHeading
                )
            }
        }
    }
}
