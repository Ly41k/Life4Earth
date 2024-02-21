package login

import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(
    navigateToMain: () -> Unit,
    navigateToForgot: () -> Unit,
    navigateToRegister: () -> Unit
) {





//    val rootController = LocalRootController.current
//
//    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
//        val state = viewModel.viewStates().observeAsState().value
//        val action = viewModel.viewSingleActions().observeAsState().value
//
//        LoginView(state = state) { viewModel.obtainEvent(it) }
//
//        when (action) {
//            is LoginAction.OpenMainFlow -> {
//                rootController.findRootController().present(
//                    screen = NavigationTree.Main.Dashboard.name,
//                    launchFlag = LaunchFlag.SingleNewTask
//                )
//            }
//
//            is LoginAction.OpenRegistrationScreen -> rootController.push(NavigationTree.Auth.Register.name)
//            is LoginAction.OpenForgotPasswordScreen -> rootController.push(NavigationTree.Auth.Forgot.name)
//            null -> {}
//        }
//    }
}
