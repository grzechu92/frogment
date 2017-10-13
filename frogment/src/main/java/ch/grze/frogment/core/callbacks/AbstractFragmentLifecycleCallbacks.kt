package ch.grze.frogment.core.callbacks

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

import ch.grze.frogment.core.Core

abstract class AbstractFragmentLifecycleCallbacks(protected val core: Core) : FragmentManager.FragmentLifecycleCallbacks() {
    @Throws(ClassCastException::class) @Deprecated("remove")
    protected fun <T> getTypedFragment(fragment: Fragment): T {
        return fragment as T
    }
}
