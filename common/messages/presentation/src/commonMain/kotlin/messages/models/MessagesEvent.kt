package messages.models

sealed class MessagesEvent {
    data object SearchClick : MessagesEvent()
}