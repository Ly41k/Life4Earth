package di

actual class PlatformConfiguration {
    actual val appName: String
        // TODO Need to use shared resources
        get() = "Life4Earth"

    actual val platform: Platform
        get() = Platform.iOS
}
