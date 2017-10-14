package ch.grze.frogmentmvp.view

import ch.grze.frogmentmvp.MvpComponent

class MvpPresenterComponent<P : MvpComponent> {
    lateinit var presenter: P
}