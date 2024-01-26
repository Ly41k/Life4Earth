import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun SplashScreen() {
    val rootController = LocalRootController.current
//    rootController.present(NavigationTree.Auth.AuthFlow.name)

    Text(
        text = "Splash Screen",
        fontSize = 24.sp,
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
        color = Color.Red
    )
}
