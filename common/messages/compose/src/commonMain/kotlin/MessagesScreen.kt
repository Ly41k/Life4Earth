import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import messages.MessagesViewModel

@Composable
fun MessagesScreen() {

    StoredViewModel(factory = { MessagesViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState().value
        val action = viewModel.viewSingleActions().observeAsState().value

        MessagesView(state = state) { viewModel.obtainEvent(it) }

    }

}
