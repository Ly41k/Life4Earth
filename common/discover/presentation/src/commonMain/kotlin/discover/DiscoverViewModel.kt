package discover

import discover.models.DiscoverAction
import discover.models.DiscoverEvent
import discover.models.DiscoverViewState
import presentation.BaseViewModel

class DiscoverViewModel : BaseViewModel<DiscoverViewState, DiscoverAction, DiscoverEvent>(
    initialState = DiscoverViewState()
) {
    override fun obtainEvent(viewEvent: DiscoverEvent) {
        TODO("Not yet implemented")
    }
}
