package login.models

sealed class LoginEvent {
    data class EmailChanged(val value: String) : LoginEvent()
    data class PasswordChanged(val value: String) : LoginEvent()
    data object ForgotClick : LoginEvent()
    data object LoginClick : LoginEvent()
    data object RegistrationClick : LoginEvent()
    data object PasswordShowClick : LoginEvent()
}
