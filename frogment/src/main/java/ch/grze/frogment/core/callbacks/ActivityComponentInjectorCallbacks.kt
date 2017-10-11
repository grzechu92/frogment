package ch.grze.frogment.core.callbacks

import android.app.Activity
import android.os.Bundle

import ch.grze.frogment.core.Core

class ActivityComponentInjectorCallbacks(core: Core) : AbstractActivityLifecycleCallbacks(core) {
    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
        super.onActivityCreated(activity, bundle)

        core.injectComponents(activity)
    }
}
