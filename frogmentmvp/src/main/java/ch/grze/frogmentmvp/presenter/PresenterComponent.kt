package ch.grze.frogmentmvp.presenter

import ch.grze.frogmentmvp.Mvp

class PresenterComponent<V : Mvp.View<*>> : ViewAware<V> {
    lateinit var presenter: Mvp.Presenter<V>

    override var view: V? = null
        set(value) {
            field = value

            if (value != null) {
                presenter.onAttach(value)
            } else {
                presenter.onDetach()
            }
        }
}