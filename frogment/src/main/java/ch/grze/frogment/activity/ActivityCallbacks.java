package ch.grze.frogment.activity;

import android.app.Activity;
import android.os.Bundle;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.callbacks.AbstractActivityLifecycleCallbacks;

public class ActivityCallbacks extends AbstractActivityLifecycleCallbacks {
    public ActivityCallbacks(Core core) {
        super(core);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        super.onActivityCreated(activity, bundle);

        try {
            final FrogmentActivityInterface frogmentActivity = getTypedActivity(activity);

            final FrogmentActivityComponent component = new FrogmentActivityComponent(core, frogmentActivity);
            frogmentActivity.setFrogmentActivityComponent(component);

            component.onActivityCreated(bundle);
        } catch (ClassCastException ignored) {}

        try {
            final StateAwareFrogmentActivityInterface stateAwareFrogmentActivity = getTypedActivity(activity);

            final StateAwareFrogmentActivityComponent component = new StateAwareFrogmentActivityComponent(core, stateAwareFrogmentActivity);
            stateAwareFrogmentActivity.setStateAwareFrogmentActivityComponent(component);

            component.onActivityCreated(bundle);
        } catch (ClassCastException ignored) {}
    }

    @Override
    public void onActivityStarted(Activity activity) {
        super.onActivityStarted(activity);

        try {
            final StateAwareFrogmentActivityInterface stateAwareFrogmentActivity = getTypedActivity(activity);

            stateAwareFrogmentActivity.getStateAwareFrogmentActivityComponent().onActivityStarted();
        } catch (ClassCastException ignored) {}
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        super.onActivitySaveInstanceState(activity, bundle);

        try {
            final FrogmentActivityInterface frogmentActivity = getTypedActivity(activity);

            frogmentActivity.getFrogmentActivityComponent().onActivitySaveInstanceState(bundle);
        } catch (ClassCastException ignored) {}

        try {
            final StateAwareFrogmentActivityInterface stateAwareFrogmentActivity = getTypedActivity(activity);

            stateAwareFrogmentActivity.getStateAwareFrogmentActivityComponent().onActivitySaveInstanceState(bundle);
        } catch (ClassCastException ignored) {}
    }
}
