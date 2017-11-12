package ch.grze.frogment

import ch.grze.frogment.StateCallbacks.*

interface StateCallbacks<in S : State> : OnBeforeStateSave<S>, OnBeforeStateChange<S>, OnStateChange<S>, OnViewStateChange<S> {
    interface OnBeforeStateSave<in S : State> {
        fun onBeforeStateSave(state: S)
    }

    interface OnBeforeStateChange<in S : State> {
        fun onBeforeStateChange(state: S)
    }

    interface OnStateChange<in S : State> {
        fun onStateChange(state: S)
    }

    interface OnViewStateChange<in S : State> {
        fun onViewStateChange(state: S)
    }
}