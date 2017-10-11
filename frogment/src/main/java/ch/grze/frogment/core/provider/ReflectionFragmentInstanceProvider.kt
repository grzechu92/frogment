package ch.grze.frogment.core.provider

import ch.grze.frogment.frogment.FrogmentInterface

class ReflectionFragmentInstanceProvider : FragmentInstanceProvider {
    override fun getInstance(frogmentClass: Class<out FrogmentInterface>): FrogmentInterface {
        try {
            return frogmentClass.newInstance()
        } catch (e: Exception) {
            when (e) {
                is InstantiationException, is IllegalAccessException -> throw UnableToCreateFrogmentInstanceException(frogmentClass)
                else -> throw e
            }
        }
    }
}
