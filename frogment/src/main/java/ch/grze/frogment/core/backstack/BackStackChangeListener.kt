package ch.grze.frogment.core.backstack

import ch.grze.frogment.frogment.FrogmentInterface

interface BackStackChangeListener {
    fun onFrogmentPushed(frogment: FrogmentInterface)
    fun onFrogmentPopped(frogment: FrogmentInterface)
    fun onBackStackEmpty()
}
