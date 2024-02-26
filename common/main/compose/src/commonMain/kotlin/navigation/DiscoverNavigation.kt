package navigation

import naviagation.BaseNavigation

sealed class DiscoverNavigation(override val route: String) : BaseNavigation(route) {
    data object Discover : DiscoverNavigation(route = "Discover")
}
