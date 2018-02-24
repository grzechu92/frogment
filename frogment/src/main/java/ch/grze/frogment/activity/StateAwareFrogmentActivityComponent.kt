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

            state?.let {
                (stateAwareFrogmentActivity as? OnBeforeStateChange<S>)?.onBeforeStateChange(it)
                (stateAwareFrogmentActivity as? OnStateChange<S>)?.onStateChange(it)

                if (isViewReady) {
                    (stateAwareFrogmentActivity as? OnViewStateChange<S>)?.onViewStateChange(it)
                }
            }
        }

    override fun onViewReady() {
        isViewReady = true

        state?.let {
            (stateAwareFrogmentActivity as? OnViewStateChange<S>)?.onViewStateChange(it)
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
        state?.let {
            (stateAwareFrogmentActivity as? OnBeforeStateChange<S>)?.onBeforeStateChange(it)

            outState.putParcelable(StateAwareFrogmentActivityInterface.STATE, it)
        }
    }

    private fun onFrogmentConfigure(frogment: FrogmentInterface) {
        (frogment as? ActivityStateProvider<*>)?.let {
            state = it.frogmentActivityState as S
        }
    }

    private fun reloadState(intent: Intent, savedInstanceState: Bundle?) {
        this.state = core.parser.getData(StateAwareFrogmentActivityInterface.STATE, stateAwareFrogmentActivity.defaultState, savedInstanceState, intent)
    }
}