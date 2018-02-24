package ch.grze.frogment.core

import ch.grze.frogment.core.provider.FragmentInstanceProvider
import ch.grze.frogment.core.provider.ReflectionFragmentInstanceProvider

class Config private constructor(builder: Builder) {
    companion object {
        @JvmStatic fun getDefault() = Config.Builder().build()
    }

    val fragmentInstanceProvider: FragmentInstanceProvider
    val isCallActivityFinishOnEmptyBackStack: Boolean

    init {
        isCallActivityFinishOnEmptyBackStack = builder.isCallActivityFinishOnEmptyBackStack
        fragmentInstanceProvider = builder.fragmentInstanceProvider
    }

    class Builder {
        internal var fragmentInstanceProvider: FragmentInstanceProvider = ReflectionFragmentInstanceProvider()
        internal var isCallActivityFinishOnEmptyBackStack = true

        fun fragmentInstanceProvider(fragmentInstanceProvider: FragmentInstanceProvider): Builder {
            this.fragmentInstanceProvider = fragmentInstanceProvider
            return this
        }

        fun callActivityFinishOnEmptyBackStack(isCallActivityFinishOnEmptyBackStack: Boolean): Builder {
            this.isCallActivityFinishOnEmptyBackStack = isCallActivityFinishOnEmptyBackStack
            return this
        }

        fun build(): Config = Config(this)
    }
}
