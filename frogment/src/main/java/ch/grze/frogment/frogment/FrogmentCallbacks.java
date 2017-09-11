package ch.grze.frogment.frogment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import ch.grze.frogment.core.Core;

public class FrogmentCallbacks extends FragmentManager.FragmentLifecycleCallbacks {
    private final Core core;

    public FrogmentCallbacks(Core core) {
        this.core = core;
    }

    @Override
    public void onFragmentPreCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
        super.onFragmentPreCreated(fm, f, savedInstanceState);

        if (f instanceof Frogment) {
            final Frogment frogment = (Frogment) f;
            frogment.setCore(core);
        }
    }
}
