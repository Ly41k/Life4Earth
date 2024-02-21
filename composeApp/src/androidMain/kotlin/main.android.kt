import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import compose.theme.AppTheme
import di.LocalPlatform
import di.Platform
import di.PlatformConfiguration
import di.appModule
import moe.tlaster.precompose.PreComposeApp
import navigation.AppNavGraph
import org.koin.compose.KoinApplication

@Composable
fun MainView(activity: ComponentActivity) {
    KoinApplication(application = {
        modules(appModule(configuration = PlatformConfiguration(activity)))
    }) {
        PreComposeApp {
            AppTheme {
                CompositionLocalProvider(
                    LocalPlatform provides Platform.Android
                ) {
                    AppNavGraph()
                }
            }
        }
    }
}
