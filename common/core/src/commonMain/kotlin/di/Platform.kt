package di

import androidx.compose.runtime.staticCompositionLocalOf

enum class Platform {
    Android, Desktop, iOS
}

data class ScreenSize(val width: Int, val height: Int)

val LocalPlatform = staticCompositionLocalOf<Platform> { error("no default platform") }

val LocalScreenSize = staticCompositionLocalOf<ScreenSize> { error("no screen size") }
