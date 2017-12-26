package ch.grze.frogmentmvp.view

import ch.grze.frogmentmvp.Mvp._Component

interface PresenterAware<P : _Component.Presenter> {
    var presenter: P?
}