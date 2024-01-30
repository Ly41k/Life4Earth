package navigation

import SplashScreen
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import utils.NavigationTree

fun RootComposeBuilder.navigationGraph() {
    screen(NavigationTree.Splash.SplashScreen.name) { SplashScreen() }
    authFlow()
}
