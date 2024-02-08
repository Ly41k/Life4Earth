package di

import android.content.Context
import com.life4earth.app.core.CoreRes

actual class PlatformConfiguration constructor(val activityContext: Context) {
    actual val appName: String
        get() = CoreRes.string.app_name
    actual val platform: Platform
        get() = Platform.Android
}
