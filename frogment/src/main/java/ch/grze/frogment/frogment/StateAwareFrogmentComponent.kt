package ch.grze.frogment.frogment

import android.os.Bundle
import ch.grze.frogment.State
import ch.grze.frogment.StateAware
import ch.grze.frogment.StateCallbacks.*
import ch.grze.frogment.ViewStateAware
import ch.grze.frogment.core.Core

class StateAwareFrogmentComponent<S : State>: StateAware<S>, ViewStateAware {
    lateinit var stateAwareFrogment: StateAwareFrogmentInterface<S>
    lateinit var core: Core

    override var isViewReady = false
    override var state: S? = null
        set(value) {
            field = value

            if (this::stateAwareFrogment.isInitialized) {
                state?.let { state ->
                    (stateAwareFrogment as? OnBeforeStateChange<S>)?.onBeforeStateChange(state)
                    (stateAwareFrogment as? OnStateChange<S>)?.onStateChange(state)

                    if (isViewReady) {
                        (stateAwareFrogment as? OnViewStateChange<S>)?.onViewStateChange(state)
                    }
                }
            }
        }

    override fun onViewReady() {
        isViewReady = true

        state?.let { state ->
            (stateAwareFrogment as? OnViewStateChange<S>)?.onViewStateChange(state)
        }
    }

    fun onFragmentPreCreated(bundle: Bundle?) {
        reloadState(stateAwareFrogment.getArguments(), bundle)
    }

    fun onFragmentActivityCreated(bundle: Bundle?) {
        onViewReady()
    }

    fun onFragmentSaveInstanceState(outState: Bundle) {
        state?.let { state ->
            (stateAwareFrogment as? OnBeforeStateSave<S>)?.onBeforeStateSave(state)
            outState.putParcelable(StateAwareFrogmentInterface.STATE, state)
        }
    }

    private fun reloadState(arguments: Bundle?, savedInstanceState: Bundle?) {
        this.state = core.parser.getData(StateAwareFrogmentInterface.STATE, stateAwareFrogment.defaultState, arguments, savedInstanceState)
    }
}