package ch.grze.frogment.activity;

import android.app.Activity;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.component.AbstractActivityComponentInjector;

public class ActivityComponentInjector extends AbstractActivityComponentInjector {
    @Override
    public void inject(Core core, Activity activity) {
        try {
            final FrogmentActivityInterface frogmentActivity = getTypedActivity(activity);

            final FrogmentActivityComponent component = new FrogmentActivityComponent(core, frogmentActivity);
            frogmentActivity.setFrogmentActivityComponent(component);
        } catch (ClassCastException ignored) {}

        try {
            final StateAwareFrogmentActivityInterface stateAwareFrogmentActivity = getTypedActivity(activity);

            final StateAwareFrogmentActivityComponent component = new StateAwareFrogmentActivityComponent(core, stateAwareFrogmentActivity);
            stateAwareFrogmentActivity.setStateAwareFrogmentActivityComponent(component);
        } catch (ClassCastException ignored) {}
    }
}
