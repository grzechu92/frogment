package ch.grze.frogmentmvp.view

import ch.grze.frogment.frogment.AbstractFrogment
import ch.grze.frogmentmvp.Mvp

abstract class AbstractMvpFrogment<P : Mvp.Presenter<*>> : AbstractFrogment(), Mvp.View<P> {
    override var presenter: P? = null
}
