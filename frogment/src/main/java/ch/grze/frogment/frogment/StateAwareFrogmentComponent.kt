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

            //TODO: in Kotlin 1.2 use: if (::stateAwareFrogment.isInitialized)
            try {
                state?.let { state ->
                    (stateAwareFrogment as? OnBeforeStateChange<S>)?.let { it.onBeforeStateChange(state) }
                    (stateAwareFrogment as? OnStateChange<S>)?.let { it.onStateChange(state) }

                    if (isViewReady) {
                        (stateAwareFrogment as? OnViewStateChange<S>)?.let { it.onViewStateChange(state) }
                    }
                }
            } catch (_: UninitializedPropertyAccessException) {}
        }

    override fun onViewReady() {
        isViewReady = true

        state?.let { state ->
            (stateAwareFrogment as? OnViewStateChange<S>)?.let { it.onViewStateChange(state) }
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
            (stateAwareFrogment as? OnBeforeStateSave<S>)?.let { it.onBeforeStateSave(state) }
            outState.putParcelable(StateAwareFrogmentInterface.STATE, state)
        }
    }

    private fun reloadState(arguments: Bundle?, savedInstanceState: Bundle?) {
        this.state = core.parser.getData(StateAwareFrogmentInterface.STATE, stateAwareFrogment.defaultState, arguments, savedInstanceState)
    }
}