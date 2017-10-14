package ch.grze.frogment.core.component

import ch.grze.frogment.core.Core

interface ComponentInjector<in T> {
    fun inject(core: Core, component: T)
}