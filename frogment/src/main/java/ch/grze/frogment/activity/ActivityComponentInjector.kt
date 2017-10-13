package ch.grze.frogment.activity

import android.app.Activity
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.component.AbstractActivityComponentInjector

class ActivityComponentInjector : AbstractActivityComponentInjector() {
    override fun inject(core: Core, activity: Activity) {
        if (activity is FrogmentActivityInterface) {
            activity.frogmentActivityComponent = FrogmentActivityComponent(core, activity)
        }

        if (activity is StateAwareFrogmentActivityInterface<*>) {
            activity.stateAwareFrogmentActivityComponent = StateAwareFrogmentActivityComponent(core, activity)
        }
    }
}