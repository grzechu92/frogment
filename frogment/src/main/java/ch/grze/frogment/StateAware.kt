package ch.grze.frogment

interface StateAware<S : State> {
    var state: S
    val defaultState: S
}
