package ch.grze.frogment.core.component;

import android.app.Activity;

import ch.grze.frogment.core.Core;

public abstract class AbstractActivityComponentInjector {
    abstract public void inject(Core core, Activity activity);

    protected <T> T getTypedActivity(Activity activity) throws ClassCastException {
        return (T) activity;
    }
}
