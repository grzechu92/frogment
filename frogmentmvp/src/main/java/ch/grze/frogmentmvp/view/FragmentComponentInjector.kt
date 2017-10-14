package ch.grze.frogmentmvp.view

import android.support.v4.app.Fragment
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.component.ComponentInjector

class FragmentComponentInjector : ComponentInjector<Fragment> {
    override fun inject(core: Core, fragment: Fragment) {
        if (fragment is PresenterAwareMvpView<*>) {
            fragment.mvpPresenterComponent = MvpPresenterComponent()
        }
    }
}