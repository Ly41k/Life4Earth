package navigation

import androidx.compose.runtime.Composable
import discover.DiscoverScreen
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun DiscoverNavGraph() {

    val navigator = rememberNavigator()
    NavHost(
        navigator = navigator,
        initialRoute = DiscoverNavigation.Discover.route,
    ) {
        scene(route = DiscoverNavigation.Discover.route) {
            DiscoverScreen()
        }
    }
}
