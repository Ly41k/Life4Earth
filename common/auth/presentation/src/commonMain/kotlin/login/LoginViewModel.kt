package login

import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginViewState
import presentation.CoreSharedViewModel

class LoginViewModel : CoreSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState()
) {
    override fun obtainEvent(viewEvent: LoginEvent) {
        println("${this::class.simpleName} viewEvent: $viewEvent")
        when (viewEvent) {
            is LoginEvent.EmailChanged -> obtainEmailChanged(viewEvent.value)
            LoginEvent.ForgotClick -> openForgotScreen()
            LoginEvent.LoginClick -> sendLogin()
            is LoginEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.value)
            LoginEvent.PasswordShowClick -> changePasswordVisibility()
            LoginEvent.RegistrationClick -> openRegistrationScreen()
        }
    }

    private fun sendLogin() {
        viewSingleAction = LoginAction.OpenMainFlow
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(isPasswordShow = !viewState.isPasswordShow)
    }

    private fun openForgotScreen() {
        viewSingleAction = LoginAction.OpenForgotPasswordScreen
    }

    private fun openRegistrationScreen() {
        viewSingleAction = LoginAction.OpenRegistrationScreen
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(email = value)
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(password = value)
    }
}
