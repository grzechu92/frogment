package ch.grze.frogment.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import ch.grze.frogment.core.Core;

public class StateAwareActivityCallbacks implements Application.ActivityLifecycleCallbacks {
    private final Core core;

    public StateAwareActivityCallbacks(Core core) {
        this.core = core;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity instanceof StateAwareFrogmentActivity) {
            final StateAwareFrogmentActivity stateAwareFrogmentActivity = (StateAwareFrogmentActivity) activity;

            if (stateAwareFrogmentActivity.getState() == null) {
                final Intent intent = stateAwareFrogmentActivity.getIntent();

                stateAwareFrogmentActivity.reloadState(intent, bundle);
            }
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {}

    @Override
    public void onActivityResumed(Activity activity) {}

    @Override
    public void onActivityPaused(Activity activity) {}

    @Override
    public void onActivityStopped(Activity activity) {}

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (activity instanceof StateAwareFrogmentActivity) {
            final StateAwareFrogmentActivity stateAwareFrogmentActivity = (StateAwareFrogmentActivity) activity;
            final FrogmentActivityState state = stateAwareFrogmentActivity.getState();

            stateAwareFrogmentActivity.onBeforeStateSave(state);
            bundle.putParcelable(StateAwareFrogmentActivity.STATE, state);
        }
    }

    @Override
    public void onActivityDestroyed(Activity activity) {}
}
