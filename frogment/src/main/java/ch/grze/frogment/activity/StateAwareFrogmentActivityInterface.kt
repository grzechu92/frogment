package ch.grze.frogment.activity

import ch.grze.frogment.DefaultStateProvider
import ch.grze.frogment.State
import ch.grze.frogment.StateAware

interface StateAwareFrogmentActivityInterface<S : State> : FrogmentActivityInterface, StateAware<S>, DefaultStateProvider<S> {
    companion object {
        val STATE = "state"
    }

    val stateAwareFrogmentActivityComponent: StateAwareFrogmentActivityComponent<S>
}
