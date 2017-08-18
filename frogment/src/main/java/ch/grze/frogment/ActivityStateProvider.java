package ch.grze.frogment;

import ch.grze.frogment.activity.FrogmentActivityState;

public interface ActivityStateProvider<T extends FrogmentActivityState> {
    T getFrogmentActivityState();
}
