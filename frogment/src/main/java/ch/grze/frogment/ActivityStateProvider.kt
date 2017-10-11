package ch.grze.frogment

interface ActivityStateProvider<out T : State> {
    val frogmentActivityState: T
}
