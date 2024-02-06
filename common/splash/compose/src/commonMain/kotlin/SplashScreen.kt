import androidx.compose.runtime.Composable
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import utils.NavigationTree

@Composable
fun SplashScreen() {
    val rootController = LocalRootController.current
    rootController.present(NavigationTree.Auth.AuthFlow.name)
}
