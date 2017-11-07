package ch.grze.frogment.frogment

import ch.grze.frogment.activity.FrogmentActivityInterface
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.navigation.FrogmentData

class FrogmentComponent(
        private val core: Core,
        private val frogment: FrogmentInterface
) {
    lateinit var data: FrogmentData

    fun getFrogmentActivity(): FrogmentActivityInterface = frogment.activity as FrogmentActivityInterface
    fun <T> getTypedActivity(): T = frogment.activity as T
}