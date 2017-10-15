package ch.grze.frogment.activity

import android.support.annotation.IdRes

import ch.grze.frogment.ActivityInterface
import ch.grze.frogment.SwitchAware
import ch.grze.frogment.core.backstack.BackStackChangeListener
import ch.grze.frogment.frogment.FrogmentData

interface FrogmentActivityInterface : ActivityInterface, BackStackChangeListener, SwitchAware {
    companion object {
        val FROGMENT_DATA = "frogment_data"
    }

    var frogmentActivityComponent: FrogmentActivityComponent

    @get:IdRes
    val frogmentContainerId: Int
    val defaultFrogmentData: FrogmentData
}
