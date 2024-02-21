package naviagtion

import naviagation.BaseNavigation

sealed class SplashNavigation(
    override val route: String
) : BaseNavigation(route) {
    data object Splash : SplashNavigation(route = "Splash")
}
