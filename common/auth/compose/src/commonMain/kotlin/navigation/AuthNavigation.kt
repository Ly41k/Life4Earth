package navigation

import forgot.ForgotPasswordScreen
import login.LoginScreen
import register.RegisterScreen
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import utils.NavigationTree

fun RootComposeBuilder.authFlow() {
    flow(name = NavigationTree.Auth.AuthFlow.name) {
        screen(name = NavigationTree.Auth.Login.name) {
            LoginScreen()
        }
        screen(name = NavigationTree.Auth.Register.name) {
            RegisterScreen()
        }
        screen(name = NavigationTree.Auth.Forgot.name) {
            ForgotPasswordScreen()
        }
    }
}
