package ch.grze.frogment.frogment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import ch.grze.frogment.core.Core;

public class StateAwareFrogmentCallbacks extends FragmentManager.FragmentLifecycleCallbacks {
    private final Core core;

    public StateAwareFrogmentCallbacks(Core core) {
        this.core = core;
    }

    @Override
    public void onFragmentPreCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
        super.onFragmentPreCreated(fm, f, savedInstanceState);

        if (f instanceof StateAwareFrogment) {
            final StateAwareFrogment stateAwareFrogment = (StateAwareFrogment) f;

            stateAwareFrogment.reloadState(stateAwareFrogment.getArguments(), savedInstanceState);
        }
    }

    @Override
    public void onFragmentSaveInstanceState(FragmentManager fm, Fragment f, Bundle outState) {
        super.onFragmentSaveInstanceState(fm, f, outState);

        if (f instanceof StateAwareFrogment) {
            final StateAwareFrogment stateAwareFrogment = (StateAwareFrogment) f;
            final FrogmentState state = stateAwareFrogment.getState();

            stateAwareFrogment.onBeforeStateSave(state);
            outState.putParcelable(StateAwareFrogment.STATE, state);
        }
    }
}
