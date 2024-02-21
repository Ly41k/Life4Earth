package naviagtion

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import splash.SplashScreen

@Composable
fun SplashNavGraph(navigateToAuth: () -> Unit) {
    val navigator = rememberNavigator()
    NavHost(
        navigator = navigator,
        initialRoute = SplashNavigation.Splash.route,
    ) {
        scene(route = SplashNavigation.Splash.route) {
            SplashScreen { navigateToAuth.invoke() }
        }
    }
}
