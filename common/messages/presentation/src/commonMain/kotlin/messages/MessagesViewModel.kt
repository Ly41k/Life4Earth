package messages

import messages.models.MessagesAction
import messages.models.MessagesEvent
import messages.models.MessagesViewState
import presentation.CoreSharedViewModel

class MessagesViewModel : CoreSharedViewModel<MessagesViewState, MessagesAction, MessagesEvent>(
    initialState = MessagesViewState()
) {
    override fun obtainEvent(viewEvent: MessagesEvent) {
        TODO("Not yet implemented")
    }
}
