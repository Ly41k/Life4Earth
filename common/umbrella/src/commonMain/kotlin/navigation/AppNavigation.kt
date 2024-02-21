package navigation

import naviagation.BaseNavigation

sealed class AppNavigation(override val route: String) : BaseNavigation(route) {
    data object Splash : AppNavigation(route = "Splash")
    data object Auth : AppNavigation(route = "Auth")
    data object Main : AppNavigation(route = "Main")
}
