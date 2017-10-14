package ch.grze.frogmentmvp.view

import ch.grze.frogmentmvp.MvpComponent

interface MvpView<P : MvpComponent> : MvpComponent {
    val presenter: P
    fun attachPresenter(presenter: P)
}
