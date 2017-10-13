package ch.grze.frogment.activity

import android.content.Intent
import android.os.Bundle
import ch.grze.frogment.ActivityStateProvider
import ch.grze.frogment.State
import ch.grze.frogment.StateAware
import ch.grze.frogment.ViewStateAware
import ch.grze.frogment.core.Core
import ch.grze.frogment.frogment.FrogmentInterface

class StateAwareFrogmentActivityComponent<S : State>(
        private val core: Core,
        private val stateAwareFrogmentActivity: StateAwareFrogmentActivityInterface<S>
) : StateAware<S>, ViewStateAware {

    override val defaultState: S = stateAwareFrogmentActivity.defaultState
    override var isViewReady: Boolean = false

    override var state: S = defaultState
        set(value) {
            field = value

            stateAwareFrogmentActivity.onBeforeStateChange(state)
            stateAwareFrogmentActivity.onStateChange(state)

            if (isViewReady) {
                stateAwareFrogmentActivity.onViewStateChange(state)
            }
        }

    override fun onViewReady() {
        isViewReady = true
        stateAwareFrogmentActivity.onViewStateChange(state)
    }

    fun onActivityCreated(savedInstanceState: Bundle?) {
        reloadState(stateAwareFrogmentActivity.getIntent(), savedInstanceState)
    }

    fun onActivityStarted() {
        onViewReady()
    }

    fun onActivitySaveInstanceState(outState: Bundle) {
        stateAwareFrogmentActivity.onBeforeStateSave(state)
        outState.putParcelable(StateAwareFrogmentActivityInterface.STATE, state)
    }

    fun onFrogmentConfigure(frogment: FrogmentInterface) {
        if (frogment is ActivityStateProvider<*>) {
            state = frogment.frogmentActivityState as S
        }
    }

    private fun reloadState(intent: Intent, savedInstanceState: Bundle?) {
        this.state = core.parser.getData(StateAwareFrogmentActivityInterface.STATE, defaultState, savedInstanceState, intent)
    }
}