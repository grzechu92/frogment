package ch.grze.frogment.activity

import android.app.Activity
import android.os.Bundle
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.callbacks.AbstractActivityLifecycleCallbacks

class ActivityCallbacks(core: Core) : AbstractActivityLifecycleCallbacks(core) {
    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
        super.onActivityCreated(activity, bundle)

        if (activity is FrogmentActivityInterface) {
            activity.frogmentActivityComponent.onActivityCreated(bundle)
        }

        if (activity is StateAwareFrogmentActivityInterface<*>) {
            activity.stateAwareFrogmentActivityComponent.onActivityCreated(bundle)
        }
    }

    override fun onActivityStarted(activity: Activity) {
        super.onActivityStarted(activity)

        if (activity is StateAwareFrogmentActivityInterface<*>) {
            activity.stateAwareFrogmentActivityComponent.onActivityStarted()
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {
        super.onActivitySaveInstanceState(activity, bundle)

        if (activity is FrogmentActivityInterface) {
            activity.frogmentActivityComponent.onActivitySaveInstanceState(bundle)
        }

        if (activity is StateAwareFrogmentActivityInterface<*>) {
            activity.stateAwareFrogmentActivityComponent.onActivitySaveInstanceState(bundle)
        }
    }
}