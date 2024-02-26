package navigation

import naviagation.BaseNavigation
import utils.NavigationTree

sealed class AuthNavigation(override val route: String) : BaseNavigation(route) {
    data object Login : AuthNavigation(route = NavigationTree.Auth.Login.name)
    data object Register : AuthNavigation(route = NavigationTree.Auth.Register.name)
    data object ForgotPassword : AuthNavigation(route = NavigationTree.Auth.Forgot.name)
}
