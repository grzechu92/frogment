package ch.grze.frogment.activity

import android.support.annotation.IdRes
import ch.grze.frogment.ActivityInterface
import ch.grze.frogment.core.backstack.BackStackChangeListener
import ch.grze.frogment.core.navigation.FrogmentData
import ch.grze.frogment.core.navigation.NavigatorAware

interface FrogmentActivityInterface : ActivityInterface, BackStackChangeListener, NavigatorAware {
    companion object {
        val FROGMENT_DATA = "frogment_data"
    }

    val frogmentActivityComponent: FrogmentActivityComponent

    @get:IdRes
    val frogmentContainerId: Int
    val defaultFrogmentData: FrogmentData
}
