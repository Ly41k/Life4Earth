package navigation

import naviagation.BaseNavigation
import utils.ImageRes.IC_BOOKMARK_TAB_SVG
import utils.ImageRes.IC_CHAT_TAB_SVG
import utils.ImageRes.IC_COMMUNITY_TAB_SVG
import utils.ImageRes.IC_DISCOVER_TAB_SVG
import utils.ImageRes.IC_MORE_TAB_SVG
import utils.NavigationTree

sealed class MainNavigation(
    override val route: String,
    val title: String,
    val selectedIcon: String
) : BaseNavigation(route) {

    data object Discover : MainNavigation(
        route = NavigationTree.Main.Discover.name,
        title = "Discover", // TODO Need to use shared recourses
        selectedIcon = IC_DISCOVER_TAB_SVG,
    )

    data object Community : MainNavigation(
        route = NavigationTree.Main.Community.name,
        title = "Community", // TODO Need to use shared recourses
        selectedIcon = IC_COMMUNITY_TAB_SVG,
    )

    data object Chat : MainNavigation(
        route = NavigationTree.Main.Chat.name,
        title = "Chat", // TODO Need to use shared recourses
        selectedIcon = IC_CHAT_TAB_SVG,
    )

    data object Bookmark : MainNavigation(
        route = NavigationTree.Main.Bookmark.name,
        title = "Bookmark", // TODO Need to use shared recourses
        selectedIcon = IC_BOOKMARK_TAB_SVG,
    )

    data object More : MainNavigation(
        route = NavigationTree.Main.More.name,
        title = "More", // TODO Need to use shared recourses
        selectedIcon = IC_MORE_TAB_SVG,
    )
}
