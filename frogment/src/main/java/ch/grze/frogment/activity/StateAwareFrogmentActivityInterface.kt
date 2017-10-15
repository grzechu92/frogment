package ch.grze.frogment.activity

import ch.grze.frogment.DefaultStateProvider
import ch.grze.frogment.State
import ch.grze.frogment.StateAware
import ch.grze.frogment.StateCallbacksAware

interface StateAwareFrogmentActivityInterface<S : State> : FrogmentActivityInterface, StateAware<S>, StateCallbacksAware<S>, DefaultStateProvider<S> {
    companion object {
        val STATE = "state"
    }

    var stateAwareFrogmentActivityComponent: StateAwareFrogmentActivityComponent<S>
}
