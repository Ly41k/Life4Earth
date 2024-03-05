import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import compose.theme.Life4EarthTheme
import compose.widgets.TopAppBarView
import messages.models.MessagesEvent
import messages.models.MessagesViewState

@Composable
fun MessagesView(
    state: MessagesViewState,
    eventHandler: (MessagesEvent) -> Unit
) {

    Scaffold(
        topBar = { TopAppBarView { eventHandler(MessagesEvent.SearchClick) } },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                shape = RoundedCornerShape(50)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add contact" //TODO Need to use shared resources
                )
            }
        },
        backgroundColor = Life4EarthTheme.colors.primaryBackground
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {

            items(state.messageGroup) {
                MessageGroupView(it) {
                    println("OnClick")
                }
            }
        }
    }
}
