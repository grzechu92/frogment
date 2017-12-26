package ch.grze.frogmentmvp.presenter

import ch.grze.frogmentmvp.Mvp

abstract class AbstractMvpPresenter<V : Mvp.View<*>> private constructor(private val presenterComponent: PresenterComponent<V>) :
        Mvp.Presenter<V>,
        ViewAware<V> by presenterComponent
{
    constructor() : this(PresenterComponent())

    init {
        presenterComponent.presenter = this
    }
}
