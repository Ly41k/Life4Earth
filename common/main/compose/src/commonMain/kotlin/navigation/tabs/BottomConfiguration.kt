package navigation.tabs

import androidx.compose.runtime.Composable
import compose.theme.Life4EarthTheme
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.BottomNavConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabsNavModel

class BottomConfiguration : TabsNavModel<BottomNavConfiguration>() {
    override val navConfiguration: BottomNavConfiguration
        @Composable
        get() {
            return BottomNavConfiguration(
                backgroundColor = Life4EarthTheme.colors.primaryBackground,
                selectedColor = Life4EarthTheme.colors.primaryText,
                unselectedColor = Life4EarthTheme.colors.primaryAction
            )
        }
}
