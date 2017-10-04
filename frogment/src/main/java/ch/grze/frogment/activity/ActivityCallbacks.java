package ch.grze.frogment.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.module.backstack.BackStackFrogmentManager;
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
            final FragmentManager fragmentManager = frogmentActivity.getSupportFragmentManager();

            new BackStackFrogmentManager(fragmentManager, frogmentActivity);

            final FrogmentData defaultFrogmentData = frogmentActivity.getDefaultFrogmentData();
            final Intent intent = frogmentActivity.getIntent();

            final FrogmentData frogmentData = core.getParser().getData(FrogmentActivity.FROGMENT_DATA, defaultFrogmentData, bundle, intent);
            frogmentActivity.switchFrogment(frogmentData);

            for (FragmentManager.FragmentLifecycleCallbacks callbacks : core.getFragmentLifecycleCallbacks()) {
                fragmentManager.registerFragmentLifecycleCallbacks(callbacks, true);
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
        if (activity instanceof FrogmentActivity) {
            final FrogmentActivity frogmentActivity = (FrogmentActivity) activity;
            final FrogmentData frogmentData = frogmentActivity.getFrogmentData();

            bundle.putParcelable(FrogmentActivity.FROGMENT_DATA, frogmentData);
        }
    }

    @Override
    public void onActivityDestroyed(Activity activity) {}
}
