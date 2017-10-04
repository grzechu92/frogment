package ch.grze.frogment.core.callbacks;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.CoreAware;

public class FragmentCallbacks extends FragmentLifecycleCallbacks {
    private final Core core;

    public FragmentCallbacks(Core core) {
        this.core = core;
    }

    @Override
    public void onFragmentAttached(FragmentManager fm, Fragment f, Context context) {
        super.onFragmentAttached(fm, f, context);

        if (f instanceof CoreAware) {
            final CoreAware coreAware = (CoreAware) f;

            coreAware.setCore(core);
        }
    }
}
