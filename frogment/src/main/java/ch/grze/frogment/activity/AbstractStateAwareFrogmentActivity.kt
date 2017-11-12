package ch.grze.frogment.activity

import ch.grze.frogment.State
import ch.grze.frogment.StateAware
import ch.grze.frogment.core.backstack.BackStackChangeListener

abstract class AbstractStateAwareFrogmentActivity<S : State> private constructor(override val stateAwareFrogmentActivityComponent: StateAwareFrogmentActivityComponent<S>) :
        AbstractFrogmentActivity(),
        StateAwareFrogmentActivityInterface<S>,
        BackStackChangeListener by stateAwareFrogmentActivityComponent,
        StateAware<S> by stateAwareFrogmentActivityComponent
{
    constructor() : this(StateAwareFrogmentActivityComponent<S>())

    init {
        stateAwareFrogmentActivityComponent.stateAwareFrogmentActivity = this
    }
}
