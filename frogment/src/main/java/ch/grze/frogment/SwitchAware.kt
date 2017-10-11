package ch.grze.frogment

import ch.grze.frogment.activity.FrogmentActivityData
import ch.grze.frogment.frogment.FrogmentData

interface SwitchAware {
    fun switchFrogment(data: FrogmentData)
    fun switchActivity(data: FrogmentActivityData)
}
