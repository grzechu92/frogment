package ch.grze.frogment.core.component

import android.support.v4.app.Fragment

import ch.grze.frogment.core.Core

abstract class AbstractFragmentComponentInjector {
    abstract fun inject(core: Core, fragment: Fragment)

    @Throws(ClassCastException::class)
    protected fun <T> getTypedFragment(fragment: Fragment): T {
        return fragment as T
    }
}
