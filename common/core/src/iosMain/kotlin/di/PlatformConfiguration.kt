package di

import com.life4earth.app.core.CoreRes

actual class PlatformConfiguration {
    actual val appName: String
        get() = CoreRes.string.app_name
    actual val platform: Platform
        get() = Platform.iOS
}
