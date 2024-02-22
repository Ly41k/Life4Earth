package login

import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginEvent.EmailChanged
import login.models.LoginEvent.ForgotClick
import login.models.LoginEvent.LoginClick
import login.models.LoginEvent.PasswordChanged
import login.models.LoginEvent.PasswordShowClick
import login.models.LoginEvent.RegistrationClick
import login.models.LoginViewState
import presentation.BaseViewModel

class LoginViewModel : BaseViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState()
) {
    override fun obtainEvent(viewEvent: LoginEvent) {
        println("${this::class.simpleName} viewEvent: $viewEvent")
        when (viewEvent) {
            is EmailChanged -> obtainEmailChanged(viewEvent.value)
            ForgotClick -> openForgotScreen()
            LoginClick -> sendLogin()
            is PasswordChanged -> obtainPasswordChanged(viewEvent.value)
            PasswordShowClick -> changePasswordVisibility()
            RegistrationClick -> openRegistrationScreen()
        }
    }

    private fun sendLogin() {
        viewAction = LoginAction.OpenMainFlow
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(isPasswordShow = !viewState.isPasswordShow)
    }

    private fun openForgotScreen() {
        viewAction = LoginAction.OpenForgotPasswordScreen
    }

    private fun openRegistrationScreen() {
        viewAction = LoginAction.OpenRegistrationScreen
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(email = value)
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(password = value)
    }
}
