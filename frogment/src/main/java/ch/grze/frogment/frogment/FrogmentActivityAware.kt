package ch.grze.frogment.frogment

import ch.grze.frogment.activity.FrogmentActivityInterface

interface FrogmentActivityAware {
    fun getFrogmentActivity(): FrogmentActivityInterface
    fun <T> getTypedActivity(): T
}