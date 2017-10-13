package ch.grze.frogment

interface ActivityStateProvider<out S : State> {
    val frogmentActivityState: S
}
