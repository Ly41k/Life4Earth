package compose.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

object Life4EarthTheme {
    internal val colors: Life4EarthColors
        @Composable
        internal get() = LocalLife4EarthColors.current

    internal val typography: Life4EarthTypography
        @Composable
        internal get() = LocalLife4EarthTypography.current

}

internal val LocalLife4EarthColors = staticCompositionLocalOf<Life4EarthColors> {
    error("No colors provided")
}

internal val LocalLife4EarthTypography = staticCompositionLocalOf<Life4EarthTypography> {
    error("No font provided")
}
