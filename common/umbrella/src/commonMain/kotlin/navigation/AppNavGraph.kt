package navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import compose.theme.Life4EarthTheme
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.rememberNavigator
import naviagtion.SplashNavGraph

@Composable
fun AppNavGraph() {
    val navigator = rememberNavigator()
    Box(modifier = Modifier.fillMaxSize().background(Life4EarthTheme.colors.primaryBackground)) {
        NavHost(
            navigator = navigator,
            initialRoute = AppNavigation.Splash.route,
        ) {
            scene(route = AppNavigation.Splash.route) {
                SplashNavGraph(
                    navigateToAuth = {
                        navigator.popBackStack()
                        navigator.navigate(AppNavigation.Auth.route)
                    }
                )
            }
            scene(route = AppNavigation.Auth.route) {
                AuthNavGraph(
                    navigateToMain = {
                        navigator.popBackStack()
                        navigator.navigate(
                            route = AppNavigation.Main.route,
                            options = NavOptions(launchSingleTop = true)
                        )
                    }
                )
            }
            scene(route = AppNavigation.Main.route) {
                MainNavGraph(
                    logout = {
                        navigator.popBackStack()
                        navigator.navigate(AppNavigation.Splash.route)
                    }
                )
            }
        }
    }
}
