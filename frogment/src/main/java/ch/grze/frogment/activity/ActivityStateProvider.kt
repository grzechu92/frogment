package ch.grze.frogment.activity

import ch.grze.frogment.State

interface ActivityStateProvider<out S : State> {
    val frogmentActivityState: S
}
