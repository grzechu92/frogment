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
                state?.let {
                    (stateAwareFrogment as? OnBeforeStateChange<S>)?.onBeforeStateChange(it)
                    (stateAwareFrogment as? OnStateChange<S>)?.onStateChange(it)

                    if (isViewReady) {
                        (stateAwareFrogment as? OnViewStateChange<S>)?.onViewStateChange(it)
                    }
                }
            }
        }

    override fun onViewReady() {
        isViewReady = true

        state?.let {
            (stateAwareFrogment as? OnViewStateChange<S>)?.onViewStateChange(it)
        }
    }

    fun onFragmentPreCreated(bundle: Bundle?) {
        reloadState(stateAwareFrogment.getArguments(), bundle)
    }

    fun onFragmentActivityCreated(bundle: Bundle?) {
        onViewReady()
    }

    fun onFragmentSaveInstanceState(outState: Bundle) {
        state?.let {
            (stateAwareFrogment as? OnBeforeStateSave<S>)?.onBeforeStateSave(it)
            outState.putParcelable(StateAwareFrogmentInterface.STATE, it)
        }
    }

    private fun reloadState(arguments: Bundle?, savedInstanceState: Bundle?) {
        this.state = core.parser.getData(StateAwareFrogmentInterface.STATE, stateAwareFrogment.defaultState, arguments, savedInstanceState)
    }
}