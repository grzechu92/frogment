package ch.grze.frogment.frogment

import ch.grze.frogment.activity.FrogmentActivityInterface
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.navigation.FrogmentData
import ch.grze.frogment.core.navigation.Navigator
import ch.grze.frogment.core.navigation.NavigatorAware

class FrogmentComponent : NavigatorAware, FrogmentActivityAware, FrogmentDataAware {
    override lateinit var data: FrogmentData
    lateinit var core: Core
    lateinit var frogment: FrogmentInterface

    override val navigator: Navigator by lazy {
        getFrogmentActivity().navigator
    }

    override fun getFrogmentActivity(): FrogmentActivityInterface = frogment.activity as FrogmentActivityInterface

    override fun <T> getTypedActivity(): T = frogment.activity as T
}