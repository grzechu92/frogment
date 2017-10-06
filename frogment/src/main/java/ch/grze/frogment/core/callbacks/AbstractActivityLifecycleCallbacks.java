package ch.grze.frogment.core.callbacks;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import ch.grze.frogment.core.Core;

public abstract class AbstractActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    protected final Core core;

    public AbstractActivityLifecycleCallbacks(Core core) {
        this.core = core;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {}

    @Override
    public void onActivityStarted(Activity activity) {}

    @Override
    public void onActivityResumed(Activity activity) {}

    @Override
    public void onActivityPaused(Activity activity) {}

    @Override
    public void onActivityStopped(Activity activity) {}

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {}

    @Override
    public void onActivityDestroyed(Activity activity) {}

    protected <T> T getTypedActivity(Activity activity) throws ClassCastException {
        return (T) activity;
    }
}
