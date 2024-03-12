import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.window.ComposeUIViewController
import compose.theme.AppTheme
import di.LocalPlatform
import di.LocalScreenSize
import di.Platform
import di.PlatformConfiguration
import di.ScreenSize
import di.appModule
import moe.tlaster.precompose.PreComposeApp
import navigation.AppNavGraph
import org.koin.compose.KoinApplication
import platform.UIKit.UIViewController

@Suppress("unused", "functionName")
fun MainViewController(): UIViewController = ComposeUIViewController {
    KoinApplication(application = {
        modules(appModule(configuration = PlatformConfiguration()))
    }) {
        PreComposeApp {
            AppTheme {
                val screenSize = remember { mutableStateOf(ScreenSize(-1, -1)) }

                CompositionLocalProvider(
                    LocalPlatform provides Platform.iOS,
                    LocalScreenSize provides screenSize.value
                ) {
                    Layout(
                        content = {
                            Box(modifier = Modifier.fillMaxSize()) { AppNavGraph() }
                        },
                        measurePolicy = { measurables, constraints ->
                            // Use the max width and height from the constraints
                            val width = constraints.maxWidth
                            val height = constraints.maxHeight

                            screenSize.value = ScreenSize(width, height)
                            println("Width: $width, height: $height")

                            // Measure and place children composables
                            val placeables = measurables.map { measurable ->
                                measurable.measure(constraints)
                            }

                            layout(width, height) {
                                var yPosition = 0
                                placeables.forEach { placeable ->
                                    placeable.placeRelative(x = 0, y = yPosition)
                                    yPosition += placeable.height
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
