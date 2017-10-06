package ch.grze.frogment.activity;

import android.app.Activity;
import android.os.Bundle;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.callbacks.AbstractActivityLifecycleCallbacks;

public class ActivityCallbacks extends AbstractActivityLifecycleCallbacks {
    private final Core core;

    public ActivityCallbacks(Core core) {
        this.core = core;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        super.onActivityCreated(activity, bundle);

        if (activity instanceof FrogmentActivityInterface) {
            final FrogmentActivityInterface frogmentActivity = (FrogmentActivityInterface) activity;

            final FrogmentActivityComponent component = new FrogmentActivityComponent(core, frogmentActivity);
            frogmentActivity.setFrogmentActivityComponent(component);

            component.onActivityCreated(bundle);
        }

        if (activity instanceof StateAwareFrogmentActivityInterface) {
            final StateAwareFrogmentActivityInterface stateAwareFrogmentActivity = (StateAwareFrogmentActivityInterface) activity;

            final StateAwareFrogmentActivityComponent component = new StateAwareFrogmentActivityComponent(core, stateAwareFrogmentActivity);
            stateAwareFrogmentActivity.setStateAwareFrogmentActivityComponent(component);

            component.onActivityCreated(bundle);
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
        super.onActivityStarted(activity);

        if (activity instanceof StateAwareFrogmentActivityInterface) {
            final StateAwareFrogmentActivityInterface stateAwareFrogmentActivity = (StateAwareFrogmentActivityInterface) activity;

            stateAwareFrogmentActivity.getStateAwareFrogmentActivityComponent().onActivityStarted();
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        super.onActivitySaveInstanceState(activity, bundle);

        if (activity instanceof FrogmentActivityInterface) {
            final FrogmentActivityInterface frogmentActivity = (FrogmentActivityInterface) activity;

            frogmentActivity.getFrogmentActivityComponent().onActivitySaveInstanceState(bundle);
        }

        if (activity instanceof StateAwareFrogmentActivityInterface) {
            final StateAwareFrogmentActivityInterface stateAwareFrogmentActivity = (StateAwareFrogmentActivityInterface) activity;

            stateAwareFrogmentActivity.getStateAwareFrogmentActivityComponent().onActivitySaveInstanceState(bundle);
        }
    }
}
