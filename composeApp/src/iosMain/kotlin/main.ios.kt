import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import compose.theme.AppTheme
import compose.theme.Life4EarthTheme
import di.LocalPlatform
import di.Platform
import di.PlatformConfiguration
import di.PlatformSDK
import navigation.navigationGraph
import platform.UIKit.UIViewController
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent

@Suppress("unused", "functionName")
fun MainViewController(): UIViewController = ComposeUIViewController {
    PlatformSDK.init(PlatformConfiguration())

    AppTheme {
        val backgroundColor = Life4EarthTheme.colors.primaryBackground
        val odysseyConfiguration = OdysseyConfiguration(backgroundColor = backgroundColor)
        CompositionLocalProvider(
            LocalPlatform provides Platform.iOS,
        ) {
            Column {
                Box(modifier = Modifier.fillMaxWidth().height(30.dp).background(backgroundColor))
                setNavigationContent(odysseyConfiguration) { navigationGraph() }
                Box(modifier = Modifier.fillMaxWidth().height(30.dp).background(backgroundColor))
            }
        }
    }
}
