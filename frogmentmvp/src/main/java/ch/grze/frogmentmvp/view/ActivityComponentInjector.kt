package ch.grze.frogmentmvp.view

import android.app.Activity
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.component.ComponentInjector

class ActivityComponentInjector : ComponentInjector<Activity> {
    override fun inject(core: Core, activity: Activity) {
        if (activity is PresenterAwareMvpView<*>) {
            activity.mvpPresenterComponent = MvpPresenterComponent()
        }
    }
}