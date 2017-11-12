package ch.grze.frogment.frogment

import ch.grze.frogment.State
import ch.grze.frogment.StateAware

abstract class AbstractStateAwareFrogment<S : State> private constructor(override val stateAwareFrogmentComponent: StateAwareFrogmentComponent<S>) :
        AbstractFrogment(),
        StateAwareFrogmentInterface<S>,
        StateAware<S> by stateAwareFrogmentComponent
{
    constructor() : this(StateAwareFrogmentComponent<S>())

    init {
        stateAwareFrogmentComponent.stateAwareFrogment = this
    }
}
