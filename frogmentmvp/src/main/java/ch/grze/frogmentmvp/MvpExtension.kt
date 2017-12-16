package ch.grze.frogmentmvp

import ch.grze.frogment.core.Core
import ch.grze.frogment.core.extension.AbstractExtension
import ch.grze.frogmentmvp.view.ActivityComponentInjector
import ch.grze.frogmentmvp.view.FragmentComponentInjector

class MvpExtension : AbstractExtension() {
    override val ID: String = "MVP_EXTENSION"

    override fun initialize(core: Core) {
        super.initialize(core)

        activityComponentInjectors.add(ActivityComponentInjector())
        fragmentComponentInjectors.add(FragmentComponentInjector())
    }
}
