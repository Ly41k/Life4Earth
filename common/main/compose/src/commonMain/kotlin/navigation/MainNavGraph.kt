package navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.theme.Life4EarthTheme
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.rememberNavigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainNavGraph(logout: () -> Unit) {

    val navigator = rememberNavigator()

    Scaffold(bottomBar = { BottomNavigationUI(navigator) }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).background(Life4EarthTheme.colors.primaryBackground)) {
            NavHost(
                navigator = navigator,
                initialRoute = MainNavigation.Discover.route,
            ) {
                scene(route = MainNavigation.Discover.route) { DiscoverNavGraph() }
                scene(route = MainNavigation.Community.route) { CommunityNavGraph() }
                scene(route = MainNavigation.Chat.route) { ChatNavGraph() }
                scene(route = MainNavigation.Bookmark.route) { BookmarkNavGraph() }
                scene(route = MainNavigation.More.route) { MoreNavGraph(logout) }
            }
        }
    }
}

@Composable
fun BottomNavigationUI(navigator: Navigator) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .background(Life4EarthTheme.colors.primaryBackground),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp
        )
    ) {
        NavigationBar(
            containerColor = Life4EarthTheme.colors.menuBackground,
            contentColor = Life4EarthTheme.colors.primaryAction,
            tonalElevation = 8.dp
        ) {

            val items = listOf(
                MainNavigation.Discover,
                MainNavigation.Community,
                MainNavigation.Chat,
                MainNavigation.Bookmark,
                MainNavigation.More
            )
            items.forEach {
                NavigationBarItem(label = { Text(text = it.title, fontSize = 10.sp) },
                    selected = it.route == currentRoute(navigator),
                    icon = {
                        when (it) {
                            MainNavigation.Chat -> TabItemIconWithBadge(it.selectedIcon, it.title)
                            MainNavigation.More -> TabItemIconWithDotBadge(it.selectedIcon, it.title)
                            MainNavigation.Community,
                            MainNavigation.Discover,
                            MainNavigation.Bookmark -> TabItemIcon(it.selectedIcon, it.title)
                        }
                    },
                    colors = DefaultNavigationBarItemTheme(),
                    onClick = { navigator.navigate(it.route, NavOptions(launchSingleTop = true)) })
            }
        }
    }
}

@Composable
fun currentRoute(navigator: Navigator): String? {
    return navigator.currentEntry.collectAsState(null).value?.route?.route
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun TabItemIcon(resIcon: String, description: String) {
    Icon(
        modifier = Modifier.size(24.dp),
        painter = painterResource(resIcon), contentDescription = description
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalResourceApi::class)
@Composable
fun TabItemIconWithDotBadge(resIcon: String, description: String) {
    BadgedBox(badge = {
        Badge(modifier = Modifier.size(8.dp)) { Text(text = "") }
    }) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(resIcon), contentDescription = description
        )
    }
}

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TabItemIconWithBadge(resIcon: String, description: String, badge: String = "99+") {
    BadgedBox(badge = { Badge { Text(text = badge) } }) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(resIcon), contentDescription = description
        )
    }
}

@Composable
fun DefaultNavigationBarItemTheme() = NavigationBarItemDefaults.colors(
    selectedIconColor = Life4EarthTheme.colors.primaryAction,
    unselectedIconColor = Life4EarthTheme.colors.primaryText,
    unselectedTextColor = Life4EarthTheme.colors.primaryText.copy(.9f),
    selectedTextColor = Life4EarthTheme.colors.primaryAction,
    indicatorColor = Life4EarthTheme.colors.primaryBackground,
)
