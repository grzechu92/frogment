package ch.grze.frogment.frogment

import android.support.v4.app.Fragment
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.component.ComponentInjector

class FrogmentComponentInjector : ComponentInjector<Fragment> {
    override fun inject(core: Core, fragment: Fragment) {
        if (fragment is FrogmentInterface) {
            fragment.frogmentComponent.core = core
        }

        if (fragment is StateAwareFrogmentInterface<*>) {
            fragment.stateAwareFrogmentComponent.core = core
        }
    }
}