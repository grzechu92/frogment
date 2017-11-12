package ch.grze.frogment.frogment

import android.os.Bundle
import ch.grze.frogment.State
import ch.grze.frogment.StateAware
import ch.grze.frogment.ViewStateAware
import ch.grze.frogment.core.Core

class StateAwareFrogmentComponent<S : State>: StateAware<S>, ViewStateAware {
    lateinit var stateAwareFrogment: StateAwareFrogmentInterface<S>
    lateinit var core: Core

    override var isViewReady = false
    override var state: S? = null
        set(value) {
            field = value

            //TODO: in Kotlin 1.2 use: if (::stateAwareFrogment.isInitialized)
            try {
                stateAwareFrogment.onBeforeStateChange(state)
                stateAwareFrogment.onStateChange(state)

                if (isViewReady) {
                    stateAwareFrogment.onViewStateChange(state)
                }
            } catch (_: UninitializedPropertyAccessException) {}
        }

    override fun onViewReady() {
        isViewReady = true
        stateAwareFrogment.onViewStateChange(state)
    }

    fun onFragmentPreCreated(bundle: Bundle?) {
        reloadState(stateAwareFrogment.getArguments(), bundle)
    }

    fun onFragmentActivityCreated(bundle: Bundle?) {
        onViewReady()
    }

    fun onFragmentSaveInstanceState(outState: Bundle) {
        stateAwareFrogment.onBeforeStateSave(state)
        outState.putParcelable(StateAwareFrogmentInterface.STATE, state)
    }

    private fun reloadState(arguments: Bundle?, savedInstanceState: Bundle?) {
        this.state = core.parser.getData(StateAwareFrogmentInterface.STATE, stateAwareFrogment.defaultState, arguments, savedInstanceState)
    }
}