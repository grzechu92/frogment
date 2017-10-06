package ch.grze.frogment.core.callbacks;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import ch.grze.frogment.core.Core;

public abstract class AbstractFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks {
    protected final Core core;

    public AbstractFragmentLifecycleCallbacks(Core core) {
        this.core = core;
    }

    protected <T> T getTypedFragment(Fragment fragment) throws ClassCastException {
        return (T) fragment;
    }
}
