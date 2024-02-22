package navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import naviagtion.SplashNavGraph

@Composable
fun AppNavGraph() {
    val navigator = rememberNavigator()
    Box(modifier = Modifier.fillMaxSize()) {
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
                        navigator.navigate(AppNavigation.Main.route)
                    }
                )
            }

            scene(route = AppNavigation.Main.route) {
//                MainNav(
//                    logout = {
//                        navigator.popBackStack()
//                        navigator.navigate(AppNavigation.Auth.route)
//                    }
//                )
            }
        }
    }


}



