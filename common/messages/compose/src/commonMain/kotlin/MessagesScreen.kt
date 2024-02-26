import androidx.compose.runtime.Composable
import messages.models.MessagesViewState

@Composable
fun MessagesScreen() {
    MessagesView(state = MessagesViewState()) { }
}
