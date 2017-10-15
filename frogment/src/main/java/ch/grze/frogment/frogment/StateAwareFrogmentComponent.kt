package ch.grze.frogment.frogment

import android.os.Bundle
import ch.grze.frogment.State
import ch.grze.frogment.StateAware
import ch.grze.frogment.ViewStateAware
import ch.grze.frogment.core.Core

class StateAwareFrogmentComponent<S : State>(
        private val core: Core,
        private val stateAwareFrogment: StateAwareFrogmentInterface<S>
) : StateAware<S>, ViewStateAware {

    override var isViewReady = false
    override var state: S? = stateAwareFrogment.defaultState
        set(value) {
            field = value

            stateAwareFrogment.onBeforeStateChange(state)
            stateAwareFrogment.onStateChange(state)

            if (isViewReady) {
                stateAwareFrogment.onViewStateChange(state)
            }
        }

    override fun onViewReady() {
        isViewReady = true
        stateAwareFrogment.onViewStateChange(state)
    }

    fun onFragmentPreCreated(bundle: Bundle?) {
        reloadState(stateAwareFrogment.arguments, bundle)
    }

    fun onFragmentActivityCreated(bundle: Bundle?) {
        onViewReady()
    }

    fun onFragmentSaveInstanceState(outState: Bundle) {
        stateAwareFrogment.onBeforeStateSave(state)
        outState.putParcelable(StateAwareFrogmentInterface.STATE, state)
    }

    private fun reloadState(arguments: Bundle, savedInstanceState: Bundle?) {
        this.state = core.parser.getData(StateAwareFrogmentInterface.STATE, stateAwareFrogment.defaultState, arguments, savedInstanceState)
    }
}