package ch.grze.frogment.activity

import android.content.Intent
import android.os.Bundle
import ch.grze.frogment.State
import ch.grze.frogment.StateAware
import ch.grze.frogment.StateCallbacks.*
import ch.grze.frogment.ViewStateAware
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.backstack.BackStackChangeListener
import ch.grze.frogment.frogment.FrogmentInterface

class StateAwareFrogmentActivityComponent<S : State> : StateAware<S>, ViewStateAware, BackStackChangeListener {
    lateinit var core: Core
    lateinit var stateAwareFrogmentActivity: StateAwareFrogmentActivityInterface<S>

    override var isViewReady: Boolean = false

    override var state: S? = null
        set(value) {
            field = value

            state?.let { state ->
                (stateAwareFrogmentActivity as? OnBeforeStateChange<S>)?.let { it.onBeforeStateChange(state) }
                (stateAwareFrogmentActivity as? OnStateChange<S>)?.let { it.onStateChange(state) }

                if (isViewReady) {
                    (stateAwareFrogmentActivity as? OnViewStateChange<S>)?.let { it.onViewStateChange(state) }
                }
            }
        }

    override fun onViewReady() {
        isViewReady = true

        state?.let { state ->
            (stateAwareFrogmentActivity as? OnViewStateChange<S>)?.let { it.onViewStateChange(state) }
        }
    }

    override fun onFrogmentPushed(frogment: FrogmentInterface) {
        onFrogmentConfigure(frogment)
    }

    override fun onFrogmentPopped(frogment: FrogmentInterface) {
        onFrogmentConfigure(frogment)
    }

    override fun onBackStackEmpty() {}

    fun onActivityCreated(savedInstanceState: Bundle?) {
        reloadState(stateAwareFrogmentActivity.getIntent(), savedInstanceState)
    }

    fun onActivityStarted() {
        onViewReady()
    }

    fun onActivitySaveInstanceState(outState: Bundle) {
        state?.let { state ->
            (stateAwareFrogmentActivity as? OnBeforeStateChange<S>)?.let { it.onBeforeStateChange(state) }

            outState.putParcelable(StateAwareFrogmentActivityInterface.STATE, state)
        }
    }

    private fun onFrogmentConfigure(frogment: FrogmentInterface) {
        if (frogment is ActivityStateProvider<*>) {
            state = frogment.frogmentActivityState as S
        }
    }

    private fun reloadState(intent: Intent, savedInstanceState: Bundle?) {
        this.state = core.parser.getData(StateAwareFrogmentActivityInterface.STATE, stateAwareFrogmentActivity.defaultState, savedInstanceState, intent)
    }
}