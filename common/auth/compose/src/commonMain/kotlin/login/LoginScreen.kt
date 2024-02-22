package login

import androidx.compose.runtime.Composable
import login.models.LoginAction
import org.koin.compose.koinInject
import presentation.collectAsState
import presentation.observeAsState

@Composable
fun LoginScreen(
    navigateToMain: () -> Unit,
    navigateToForgot: () -> Unit,
    navigateToRegister: () -> Unit
) {

    val viewModel: LoginViewModel = koinInject()
    val state = viewModel.viewStates().collectAsState().value
    val action = viewModel.viewActions().observeAsState().value

    LoginView(state = state) { viewModel.obtainEvent(it) }

    when (action) {
        is LoginAction.OpenMainFlow -> navigateToMain.invoke()
        is LoginAction.OpenRegistrationScreen -> navigateToRegister.invoke()
        is LoginAction.OpenForgotPasswordScreen -> navigateToForgot.invoke()
        null -> {}
    }
}
