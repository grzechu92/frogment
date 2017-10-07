package ch.grze.frogment.core.component;

import android.support.v4.app.Fragment;

import ch.grze.frogment.core.Core;

public abstract class AbstractFragmentComponentInjector {
    abstract public void inject(Core core, Fragment fragment);

    protected <T> T getTypedFragment(Fragment fragment) throws ClassCastException {
        return (T) fragment;
    }
}
