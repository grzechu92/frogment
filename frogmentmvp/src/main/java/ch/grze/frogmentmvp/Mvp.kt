package ch.grze.frogmentmvp

import ch.grze.frogmentmvp.presenter.ViewAware
import ch.grze.frogmentmvp.view.PresenterAware

interface Mvp {
    interface _Component {
        interface Presenter
        interface View
    }

    interface Presenter<V: _Component.View> : _Component.Presenter, ViewAware<V> {
        fun onAttach(view: V)
        fun onDetach()
    }

    interface View<P : _Component.Presenter> : _Component.View, PresenterAware<P>
}