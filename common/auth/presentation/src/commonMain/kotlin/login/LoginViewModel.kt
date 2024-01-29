package login

import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginViewState
import presentation.CoreSharedViewModel

class LoginViewModel : CoreSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState()
) {
    override fun obtainEvent(viewEvent: LoginEvent) {
        TODO("Not yet implemented")
    }
}
