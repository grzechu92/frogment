package ch.grze.frogment.frogment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.callbacks.AbstractFragmentLifecycleCallbacks;

public class FragmentCallbacks extends AbstractFragmentLifecycleCallbacks {
    public FragmentCallbacks(Core core) {
        super(core);
    }

    @Override
    public void onFragmentPreCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
        super.onFragmentPreCreated(fm, f, savedInstanceState);

        try {
            final StateAwareFrogmentInterface stateAwareFrogment = getTypedFragment(f);

            stateAwareFrogment.getStateAwareFrogmentComponent().onFragmentPreCreated(savedInstanceState);
        } catch (ClassCastException ignored) {}
    }

    @Override
    public void onFragmentActivityCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
        super.onFragmentActivityCreated(fm, f, savedInstanceState);

        try {
            final StateAwareFrogmentInterface stateAwareFrogment = getTypedFragment(f);

            stateAwareFrogment.getStateAwareFrogmentComponent().onFragmentActivityCreated(savedInstanceState);
        } catch (ClassCastException ignored) {}
    }

    @Override
    public void onFragmentSaveInstanceState(FragmentManager fm, Fragment f, Bundle outState) {
        super.onFragmentSaveInstanceState(fm, f, outState);

        try {
            final StateAwareFrogmentInterface stateAwareFrogment = getTypedFragment(f);

            stateAwareFrogment.getStateAwareFrogmentComponent().onFragmentSaveInstanceState(outState);
        } catch (ClassCastException ignored) {}
    }
}
