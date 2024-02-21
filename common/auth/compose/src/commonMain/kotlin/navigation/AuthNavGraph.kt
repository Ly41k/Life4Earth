package navigation

import androidx.compose.runtime.Composable
import forgot.ForgotPasswordScreen
import login.LoginScreen
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import register.RegisterScreen

@Composable
fun AuthNavGraph(navigateToMain: () -> Unit) {
    val navigator = rememberNavigator()

    NavHost(
        navigator = navigator,
        initialRoute = AuthNavigation.Login.route,
    ) {
        scene(route = AuthNavigation.Login.route) {
            LoginScreen(
                navigateToMain = navigateToMain,
                navigateToForgot = { navigator.navigate(AuthNavigation.ForgotPassword.route) },
                navigateToRegister = { navigator.navigate(AuthNavigation.Register.route) }
            )
        }

        scene(route = AuthNavigation.ForgotPassword.route) {
            ForgotPasswordScreen(
                navigateToRegister = { navigator.navigate(AuthNavigation.Register.route) },
                popUp = { navigator.popBackStack() },
            )
        }
        scene(route = AuthNavigation.Register.route) {
            RegisterScreen(
                navigateToMain = navigateToMain,
                navigateToForgot = { navigator.navigate(AuthNavigation.ForgotPassword.route) },
                popUp = { navigator.popBackStack() },
            )
        }
    }
}
