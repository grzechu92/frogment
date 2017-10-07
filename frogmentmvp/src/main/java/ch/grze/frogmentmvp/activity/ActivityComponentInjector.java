package ch.grze.frogmentmvp.activity;

import android.app.Activity;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.component.AbstractActivityComponentInjector;

public class ActivityComponentInjector extends AbstractActivityComponentInjector {
    @Override
    public void inject(Core core, Activity activity) {
        try {
            final MvpActivityInterface mvpActivity = getTypedActivity(activity);

            final MvpActivityComponent component = new MvpActivityComponent(core, mvpActivity);
            mvpActivity.setMvpActivityComponent(component);
        } catch (ClassCastException ignored) {}
    }
}
