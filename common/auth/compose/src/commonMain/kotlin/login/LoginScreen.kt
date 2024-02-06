package login

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.models.LoginAction
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import utils.NavigationTree

@Composable
fun LoginScreen() {

    val rootController = LocalRootController.current

    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState().value
        val action = viewModel.viewSingleActions().observeAsState().value

        LoginView(state = state) { viewModel.obtainEvent(it) }

        when (action) {
            is LoginAction.OpenMainFlow -> {}
            is LoginAction.OpenRegistrationScreen -> rootController.push(NavigationTree.Auth.Register.name)
            is LoginAction.OpenForgotPasswordScreen -> rootController.push(NavigationTree.Auth.Forgot.name)
            null -> {}
        }
    }
}
