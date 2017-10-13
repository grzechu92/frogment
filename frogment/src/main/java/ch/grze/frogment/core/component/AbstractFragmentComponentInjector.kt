package ch.grze.frogment.core.component

import android.support.v4.app.Fragment

@Deprecated("fallback, use ComponentInjector")
abstract class AbstractFragmentComponentInjector : ComponentInjector<Fragment> {
    @Throws(ClassCastException::class)
    protected fun <T> getTypedFragment(fragment: Fragment): T = fragment as T
}
