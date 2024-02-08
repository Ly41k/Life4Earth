package navigation.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import compose.theme.Life4EarthTheme
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabItem

class DiscoverTab : TabItem() {
    override val configuration: TabConfiguration
        @Composable
        get() {

            return TabConfiguration(
                title = "Discover", // TODO Need to use Shared resources
                selectedColor = Life4EarthTheme.colors.primaryAction,
                unselectedColor = Life4EarthTheme.colors.primaryText,
                titleStyle = Life4EarthTheme.typography.bottomNavBar,
                selectedIcon = rememberVectorPainter(image = Icons.Filled.Home),
                unselectedIcon = rememberVectorPainter(image = Icons.Outlined.Home)
            )
        }
}

class CommunityTab : TabItem() {
    override val configuration: TabConfiguration
        @Composable
        get() {

            return TabConfiguration(
                title = "Community",// TODO Need to use Shared resources
                selectedColor = Life4EarthTheme.colors.primaryAction,
                unselectedColor = Life4EarthTheme.colors.primaryText,
                titleStyle = Life4EarthTheme.typography.bottomNavBar,
                selectedIcon = rememberVectorPainter(image = Icons.Filled.Share),
                unselectedIcon = rememberVectorPainter(image = Icons.Outlined.Share)
            )
        }
}

class MessagesTab : TabItem() {
    override val configuration: TabConfiguration
        @Composable
        get() {

            return TabConfiguration(
                title = "Messages",// TODO Need to use Shared resources
                selectedColor = Life4EarthTheme.colors.primaryAction,
                unselectedColor = Life4EarthTheme.colors.primaryText,
                titleStyle = Life4EarthTheme.typography.bottomNavBar,
                selectedIcon = rememberVectorPainter(image = Icons.Filled.Email),
                unselectedIcon = rememberVectorPainter(image = Icons.Outlined.Email)
            )
        }
}

class FavoriteTab : TabItem() {
    override val configuration: TabConfiguration
        @Composable
        get() {

            return TabConfiguration(
                title = "Favorite",// TODO Need to use Shared resources
                selectedColor = Life4EarthTheme.colors.primaryAction,
                unselectedColor = Life4EarthTheme.colors.primaryText,
                titleStyle = Life4EarthTheme.typography.bottomNavBar,
                selectedIcon = rememberVectorPainter(image = Icons.Filled.Favorite),
                unselectedIcon = rememberVectorPainter(image = Icons.Outlined.Favorite)
            )
        }
}

class MoreTab : TabItem() {
    override val configuration: TabConfiguration
        @Composable
        get() {

            return TabConfiguration(
                title = "More",// TODO Need to use Shared resources
                selectedColor = Life4EarthTheme.colors.primaryAction,
                unselectedColor = Life4EarthTheme.colors.primaryText,
                titleStyle = Life4EarthTheme.typography.bottomNavBar,
                selectedIcon = rememberVectorPainter(image = Icons.Filled.AccountCircle),
                unselectedIcon = rememberVectorPainter(image = Icons.Outlined.AccountCircle)
            )
        }
}
