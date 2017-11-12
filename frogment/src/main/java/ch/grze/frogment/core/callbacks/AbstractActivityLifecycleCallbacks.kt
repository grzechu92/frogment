package ch.grze.frogment.core.callbacks

import android.app.Activity
import android.app.Application
import android.os.Bundle

import ch.grze.frogment.core.Core

abstract class AbstractActivityLifecycleCallbacks(protected val core: Core) : Application.ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {}

    override fun onActivityStarted(activity: Activity) {}

    override fun onActivityResumed(activity: Activity) {}

    override fun onActivityPaused(activity: Activity) {}

    override fun onActivityStopped(activity: Activity) {}

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

    override fun onActivityDestroyed(activity: Activity) {}
}
