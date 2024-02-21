import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.life4earth.app.core.CoreRes
import compose.theme.AppTheme
import di.LocalPlatform
import di.Platform
import di.PlatformConfiguration
import di.appModule
import moe.tlaster.precompose.PreComposeApp
import navigation.AppNavGraph
import org.koin.compose.KoinApplication

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
    KoinApplication(application = {
        modules(appModule(configuration = PlatformConfiguration()))
    }) {
        PreComposeApp {
            AppTheme {
                CompositionLocalProvider(
                    LocalPlatform provides Platform.Desktop
                ) {
                    AppNavGraph()
                }
            }
        }
    }
}
