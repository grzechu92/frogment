package ch.grze.frogment.core.component

import android.app.Activity

import ch.grze.frogment.core.Core

abstract class AbstractActivityComponentInjector {
    abstract fun inject(core: Core, activity: Activity)

    @Throws(ClassCastException::class)
    protected fun <T> getTypedActivity(activity: Activity): T {
        return activity as T
    }
}
