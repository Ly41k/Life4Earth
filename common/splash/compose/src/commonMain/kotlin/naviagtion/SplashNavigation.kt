package naviagtion

import naviagation.BaseNavigation
import utils.NavigationTree

sealed class SplashNavigation(
    override val route: String
) : BaseNavigation(route) {
    data object Splash : SplashNavigation(route = NavigationTree.Splash.Splash.name)
}
