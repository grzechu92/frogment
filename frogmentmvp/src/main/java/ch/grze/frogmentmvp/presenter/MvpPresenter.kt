package ch.grze.frogmentmvp.presenter

import ch.grze.frogmentmvp.MvpComponent

interface MvpPresenter<V : MvpComponent> : MvpComponent {
    val view: V
    fun onAttach(view: V)
}
