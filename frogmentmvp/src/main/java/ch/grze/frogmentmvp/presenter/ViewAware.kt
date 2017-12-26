package ch.grze.frogmentmvp.presenter

import ch.grze.frogmentmvp.Mvp._Component

interface ViewAware<V : _Component.View> {
    var view: V?
}