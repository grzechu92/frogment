package ch.grze.frogment.frogment

import ch.grze.frogment.FragmentInterface
import ch.grze.frogment.core.navigation.FrogmentData
import ch.grze.frogment.core.navigation.NavigatorAware

interface FrogmentInterface : FragmentInterface, FrogmentActivityAware, NavigatorAware {
    val frogmentComponent: FrogmentComponent

    var data: FrogmentData
}
