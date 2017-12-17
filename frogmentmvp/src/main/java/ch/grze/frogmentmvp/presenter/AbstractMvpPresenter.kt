package ch.grze.frogmentmvp.presenter

import ch.grze.frogmentmvp.Mvp

abstract class AbstractMvpPresenter<V : Mvp.View<*>> : Mvp.Presenter<V> {
    override var view: V? = null
}
