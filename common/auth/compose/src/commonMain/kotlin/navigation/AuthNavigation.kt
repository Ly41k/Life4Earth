package navigation

import naviagation.BaseNavigation

sealed class AuthNavigation(override val route: String) : BaseNavigation(route) {
    data object Login : AuthNavigation(route = "Login")
    data object Register : AuthNavigation(route = "Register")
    data object ForgotPassword : AuthNavigation(route = "Forgot")
}
