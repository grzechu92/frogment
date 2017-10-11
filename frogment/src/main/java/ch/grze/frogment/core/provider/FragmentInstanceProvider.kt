package ch.grze.frogment.core.provider

import ch.grze.frogment.frogment.FrogmentInterface

interface FragmentInstanceProvider {
    fun getInstance(frogmentClass: Class<out FrogmentInterface>): FrogmentInterface
}
