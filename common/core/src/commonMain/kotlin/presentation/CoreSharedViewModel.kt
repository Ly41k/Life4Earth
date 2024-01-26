package presentation

import com.adeo.kviewmodel.BaseSharedViewModel
import com.adeo.kviewmodel.WrappedSharedFlow
import kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class CoreSharedViewModel<State : Any, Action, Event>(initialState: State) :
    BaseSharedViewModel<State, Action, Event>(initialState) {

    private val _viewSingleActions = MutableSharedFlow<Action?>(extraBufferCapacity = 1, onBufferOverflow = DROP_OLDEST)

    fun viewSingleActions(): WrappedSharedFlow<Action?> = WrappedSharedFlow(_viewSingleActions.asSharedFlow())

    protected var viewSingleAction: Action?
        get() = _viewSingleActions.replayCache.last()
        set(value) {
            _viewSingleActions.tryEmit(value)
        }
}
