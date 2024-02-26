package navigation

import naviagation.BaseNavigation

sealed class MainNavigation(
    override val route: String,
    val title: String,
    val selectedIcon: String
) : BaseNavigation(route) {

    data object Discover : MainNavigation(
        route = "Discover",
        title = "Discover",
        selectedIcon = "ic_discover_tab.xml",
    )

    data object Community : MainNavigation(
        route = "Community",
        title = "Community",
        selectedIcon = "ic_community_tab.xml",
    )

    data object Chat : MainNavigation(
        route = "Chat",
        title = "Chat",
        selectedIcon = "ic_chat_tab.xml",
    )

    data object Bookmark : MainNavigation(
        route = "Bookmark",
        title = "Bookmark",
        selectedIcon = "ic_bookmark_tab.xml",
    )

    data object More : MainNavigation(
        route = "More",
        title = "More",
        selectedIcon = "ic_more_tab.xml",
    )
}
