package ch.grze.frogmentmvp.view;

import android.app.Activity;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.component.AbstractActivityComponentInjector;

public class ActivityComponentInjector extends AbstractActivityComponentInjector {
    @Override
    public void inject(Core core, Activity activity) {
        try {
            final PresenterAwareMvpView mvpActivity = getTypedActivity(activity);

            final MvpPresenterComponent component = new MvpPresenterComponent(mvpActivity);
            mvpActivity.setMvpPresenterComponent(component);
        } catch (ClassCastException ignored) {}
    }
}
