package compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
internal fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) darkColorScheme else lightColorScheme

    CompositionLocalProvider(
        LocalLife4EarthColors provides colors,
        LocalLife4EarthTypography provides typography,
        content = content
    )
}
