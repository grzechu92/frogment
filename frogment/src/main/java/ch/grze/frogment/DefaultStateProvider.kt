package ch.grze.frogment

interface DefaultStateProvider<out S : State> {
    val defaultState: S
}