package di

import androidx.compose.runtime.staticCompositionLocalOf

enum class Platform {
    Android, Desktop, iOS
}

internal val LocalPlatform = staticCompositionLocalOf<Platform> { error("no default platform") }
