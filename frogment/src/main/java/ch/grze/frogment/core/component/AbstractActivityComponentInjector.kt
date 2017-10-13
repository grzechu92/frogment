package ch.grze.frogment.core.component

import android.app.Activity

import ch.grze.frogment.core.Core

@Deprecated("fallback, use ComponentInjector")
abstract class AbstractActivityComponentInjector : ComponentInjector<Activity> {
    @Throws(ClassCastException::class)
    protected fun <T> getTypedActivity(activity: Activity): T = activity as T
}
