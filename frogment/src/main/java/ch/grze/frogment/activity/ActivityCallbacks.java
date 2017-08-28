package ch.grze.frogment.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.frogment.FrogmentData;

public class ActivityCallbacks implements Application.ActivityLifecycleCallbacks {
    private final Core core;

    public ActivityCallbacks(Core core) {
        this.core = core;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity instanceof FrogmentActivity) {
            final FrogmentActivity frogmentActivity = (FrogmentActivity) activity;
            final FrogmentData defaultFrogmentData = frogmentActivity.getDefaultFrogmentData();
            final Intent intent = frogmentActivity.getIntent();

            final FrogmentData frogmentData = frogmentActivity.getData(FrogmentActivity.FROGMENT_DATA, defaultFrogmentData, intent, bundle);
            frogmentActivity.switchFrogment(frogmentData);

            frogmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(core.getStateAwareFrogmentCallbacks(), true);
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
        if (activity instanceof FrogmentActivity) {
            final FrogmentActivity frogmentActivity = (FrogmentActivity) activity;
            final FrogmentData frogmentData = frogmentActivity.getFrogmentData();

            bundle.putParcelable(FrogmentActivity.FROGMENT_DATA, frogmentData);
        }
    }

    @Override
    public void onActivityDestroyed(Activity activity) {}
}