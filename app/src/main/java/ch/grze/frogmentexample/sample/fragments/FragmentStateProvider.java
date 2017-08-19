package ch.grze.frogmentexample.sample.fragments;

import ch.grze.frogment.ActivityStateProvider;
import ch.grze.frogmentexample.sample.activitystateprovider.State;

public class FragmentStateProvider extends FragmentFirst implements ActivityStateProvider<State> {
    @Override
    public State getFrogmentActivityState() {
        return new State("State from fragment");
    }
}
