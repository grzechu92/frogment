package ch.grze.frogmentmvp.fragment

import ch.grze.frogment.State
import ch.grze.frogment.frogment.AbstractStateAwareFrogment
import ch.grze.frogmentmvp.Mvp

abstract class AbstractMvpStateAwareFrogment<S : State, P : Mvp.Presenter<*>> : AbstractStateAwareFrogment<S>(), Mvp.View<P> {
    override var presenter: P? = null
}
