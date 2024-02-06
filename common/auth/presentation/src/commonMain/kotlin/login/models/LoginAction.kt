package login.models

sealed class LoginAction {
    data object OpenRegistrationScreen : LoginAction()
    data object OpenForgotPasswordScreen : LoginAction()
    data object OpenMainFlow : LoginAction()
}
