import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.life4earth.app.core.CoreRes
import compose.theme.AppTheme
import compose.theme.Life4EarthTheme
import di.LocalPlatform
import di.Platform
import di.PlatformConfiguration
import di.PlatformSDK
import navigation.navigationGraph
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = CoreRes.string.app_name,
        state = WindowState(size = DpSize(800.dp, 800.dp))
    ) {
        MainView()
    }
}

@Composable
fun MainView() {
    PlatformSDK.init(PlatformConfiguration())

    AppTheme {
        val odysseyConfiguration = OdysseyConfiguration(
            backgroundColor = Life4EarthTheme.colors.primaryBackground
        )

        CompositionLocalProvider(
            LocalPlatform provides Platform.Desktop,
        ) {
            setNavigationContent(odysseyConfiguration) { navigationGraph() }
        }
    }
}
