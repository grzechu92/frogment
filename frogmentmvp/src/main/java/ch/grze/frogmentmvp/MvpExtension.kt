package ch.grze.frogmentmvp

import ch.grze.frogment.core.Core
import ch.grze.frogment.core.extension.AbstractExtension
import ch.grze.frogmentmvp.view.ActivityComponentInjector
import ch.grze.frogmentmvp.view.FragmentComponentInjector

class MvpExtension : AbstractExtension() {
    override fun initialize(core: Core) {
        super.initialize(core)

        addActivityComponentInjector(ActivityComponentInjector())
        addFragmentComponentInjector(FragmentComponentInjector())
    }
}
