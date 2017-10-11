package ch.grze.frogment.core

import ch.grze.frogment.core.provider.FragmentInstanceProvider
import ch.grze.frogment.core.provider.ReflectionFragmentInstanceProvider

class Config private constructor(builder: Builder) {
    val fragmentInstanceProvider: FragmentInstanceProvider
    val isCallActivityFinishOnEmptyBackStack: Boolean

    init {
        isCallActivityFinishOnEmptyBackStack = builder.isCallActivityFinishOnEmptyBackStack
        fragmentInstanceProvider = builder.fragmentInstanceProvider
    }

    class Builder {
        var fragmentInstanceProvider: FragmentInstanceProvider = ReflectionFragmentInstanceProvider()
        var isCallActivityFinishOnEmptyBackStack = true

        fun build(): Config {
            return Config(this)
        }
    }

    companion object {
        val default: Config = Config.Builder().build()
    }
}
