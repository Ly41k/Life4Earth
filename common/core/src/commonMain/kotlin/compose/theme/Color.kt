package compose.theme

import androidx.compose.ui.graphics.Color

internal val lightColorScheme = Life4EarthColors(
    primaryBackground = Color(0xFFCFCFCF),
    headerBackground = Color(0xFFFEFEFE),
    menuBackground = Color(0xFFF5F5F5),
    primaryText = Color(0xFF484848),
    secondaryText = Color(0xFF97A2A5), // TODO Need to check
    primaryAction = Color(0xFFFF993A),
    focusedBorderColor = Color(0xFF1E3E66),
    unfocusedBorderColor = Color(0xFF657079),
    googleButtonBackground = Color(0xFF4285F4),
)

internal val darkColorScheme = Life4EarthColors(
    primaryBackground = Color(0xFF242D34),
    headerBackground = Color(0xFF323D47),
    menuBackground = Color(0xFF2A343D),
    primaryText = Color(0xFFFFFFFF),
    secondaryText = Color(0xFF97A2A5),
    primaryAction = Color(0xFFFF993A),
    focusedBorderColor = Color(0xFF1E3E66),
    unfocusedBorderColor = Color(0xFF657079),
    googleButtonBackground = Color(0xFF4285F4)
)
