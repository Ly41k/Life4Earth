import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import compose.theme.AppTheme
import compose.theme.Life4EarthTheme
import di.LocalPlatform
import di.Platform
import navigation.navigationGraph
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent

@Composable
fun MainView(activity: ComponentActivity) {

    AppTheme {
        val odysseyConfiguration = OdysseyConfiguration(
            canvas = activity,
            backgroundColor = Life4EarthTheme.colors.primaryBackground
        )

        CompositionLocalProvider(
            LocalPlatform provides Platform.Android,
        ) {
            setNavigationContent(odysseyConfiguration, onApplicationFinish = {
                activity.finishAffinity()
            }) {
                navigationGraph()
            }
        }
    }
}
