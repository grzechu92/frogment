package ch.grze.frogment.activity

import android.app.Activity
import android.os.Bundle
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.callbacks.AbstractActivityLifecycleCallbacks

class ActivityCallbacks(core: Core) : AbstractActivityLifecycleCallbacks(core) {
    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
        super.onActivityCreated(activity, bundle)

        (activity as? FrogmentActivityInterface)
            ?.frogmentActivityComponent
            ?.onActivityCreated(bundle)

        (activity as? StateAwareFrogmentActivityInterface<*>)
            ?.stateAwareFrogmentActivityComponent
            ?.onActivityCreated(bundle)
    }

    override fun onActivityStarted(activity: Activity) {
        super.onActivityStarted(activity)

        (activity as? StateAwareFrogmentActivityInterface<*>)
            ?.stateAwareFrogmentActivityComponent
            ?.onActivityStarted()
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        super.onActivitySaveInstanceState(activity, outState)

        (activity as? FrogmentActivityInterface)
            ?.frogmentActivityComponent
            ?.onActivitySaveInstanceState(outState)

        (activity as? StateAwareFrogmentActivityInterface<*>)
            ?.stateAwareFrogmentActivityComponent
            ?.onActivitySaveInstanceState(outState)
    }
}