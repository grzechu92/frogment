package ch.grze.frogment

interface StateCallbacksAware<in S : State> {
    fun onBeforeStateSave(state: S) {}
    fun onBeforeStateChange(state: S) {}
    fun onStateChange(state: S) {}
    fun onViewStateChange(state: S) {}
}
