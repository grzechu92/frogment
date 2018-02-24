package ch.grze.frogment.activity

import android.app.Activity
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.component.ComponentInjector

class ActivityComponentInjector : ComponentInjector<Activity> {
    override fun inject(core: Core, activity: Activity) {
        (activity as? FrogmentActivityInterface)
            ?.frogmentActivityComponent
            ?.core = core

        (activity as? StateAwareFrogmentActivityInterface<*>)
            ?.stateAwareFrogmentActivityComponent
            ?.core = core
    }
}