package ch.grze.frogmentexample.sample.activitystateprovider;

import ch.grze.frogment.activity.ActivityStateProvider;
import ch.grze.frogmentexample.sample.commons.FragmentFirst;

public class FragmentStateProvider extends FragmentFirst implements ActivityStateProvider<State> {
    @Override
    public State getFrogmentActivityState() {
        return new State("State from fragment");
    }
}
