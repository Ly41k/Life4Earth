package navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import compose.theme.Life4EarthTheme
import navigation.tabs.BottomConfiguration
import navigation.tabs.CommunityTab
import navigation.tabs.DiscoverTab
import navigation.tabs.FavoriteTab
import navigation.tabs.MessagesTab
import navigation.tabs.MoreTab
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import utils.NavigationTree

fun RootComposeBuilder.mainFlow() {
    bottomNavigation(
        name = NavigationTree.Main.Dashboard.name,
        tabsNavModel = BottomConfiguration()
    ) {

        tab(DiscoverTab()) {
            screen(name = NavigationTree.Main.Discover.name) {
                Column(
                    modifier = Modifier.fillMaxSize().background(Color.Red),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "DiscoverTab",
                        color = Life4EarthTheme.colors.primaryText,
                        style = Life4EarthTheme.typography.mediumHeading,
                    )
                }
            }
        }

        tab(CommunityTab()) {
            screen(name = NavigationTree.Main.Community.name) {
                Column(
                    modifier = Modifier.fillMaxSize().background(Color.Red),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "CommunityTab",
                        color = Life4EarthTheme.colors.primaryText,
                        style = Life4EarthTheme.typography.mediumHeading
                    )
                }
            }
        }

        tab(MessagesTab()) {
            screen(name = NavigationTree.Main.Messages.name) {
                Column(
                    modifier = Modifier.fillMaxSize().background(Color.Red),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "MessagesTab",
                        color = Life4EarthTheme.colors.primaryText,
                        style = Life4EarthTheme.typography.mediumHeading
                    )
                }
            }
        }

        tab(FavoriteTab()) {
            screen(name = NavigationTree.Main.Favorite.name) {
                Column(
                    modifier = Modifier.fillMaxSize().background(Color.Red),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "FavoriteTab",
                        color = Life4EarthTheme.colors.primaryText,
                        style = Life4EarthTheme.typography.mediumHeading
                    )
                }
            }
        }

        tab(MoreTab()) {
            screen(name = NavigationTree.Main.More.name) {
                Column(
                    modifier = Modifier.fillMaxSize().background(Color.Red),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "MoreTab",
                        color = Life4EarthTheme.colors.primaryText,
                        style = Life4EarthTheme.typography.mediumHeading
                    )
                }
            }
        }
    }
}
