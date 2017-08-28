package ch.grze.frogment.core;

import android.app.Application;

import ch.grze.frogment.activity.ActivityCallbacks;
import ch.grze.frogment.activity.StateAwareActivityCallbacks;
import ch.grze.frogment.frogment.StateAwareFrogmentCallbacks;

public class Core {
    private final ActivityCallbacks activityCallbacks;
    private final StateAwareActivityCallbacks stateAwareActivityCallbacks;
    private final StateAwareFrogmentCallbacks stateAwareFrogmentCallbacks;

    private final Application application;

    public Core(Application application) {
        this.application = application;

        activityCallbacks = new ActivityCallbacks(this);
        stateAwareActivityCallbacks = new StateAwareActivityCallbacks(this);
        stateAwareFrogmentCallbacks = new StateAwareFrogmentCallbacks(this);

        application.registerActivityLifecycleCallbacks(getActivityCallbacks());
        application.registerActivityLifecycleCallbacks(getStateAwareActivityCallbacks());
    }

    public ActivityCallbacks getActivityCallbacks() {
        return activityCallbacks;
    }

    public StateAwareActivityCallbacks getStateAwareActivityCallbacks() {
        return stateAwareActivityCallbacks;
    }

    public StateAwareFrogmentCallbacks getStateAwareFrogmentCallbacks() {
        return stateAwareFrogmentCallbacks;
    }
}
