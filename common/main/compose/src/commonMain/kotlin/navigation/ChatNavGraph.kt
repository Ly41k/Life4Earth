package navigation

import MessagesScreen
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun ChatNavGraph() {
    val navigator = rememberNavigator()
    NavHost(
        navigator = navigator,
        initialRoute = DiscoverNavigation.Discover.route,
    ) {
        scene(route = DiscoverNavigation.Discover.route) {
            MessagesScreen()
        }
    }
}
