package ch.grze.frogmentexample.sample.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ch.grze.frogment.ActivityStateProvider;
import ch.grze.frogment.frogment.Frogment;
import ch.grze.frogmentexample.R;
import ch.grze.frogmentexample.sample.activitystateprovider.State;

public class FragmentStateProvider extends Frogment implements ActivityStateProvider<State> {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public State getFrogmentActivityState() {
        return new State("State from fragment");
    }
}
