package ch.grze.frogmentmvp

interface Mvp {
    interface Presenter<V: _ComponentView> : _ComponentPresenter {
        var view: V?

        fun onAttach(view: V)
        fun onDetach()
    }

    interface View<P : _ComponentPresenter> : _ComponentView {
        var presenter: P?
    }

    interface _ComponentPresenter
    interface _ComponentView
}