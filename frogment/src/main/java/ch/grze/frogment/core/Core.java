package ch.grze.frogment.core;

import android.app.Application;

import ch.grze.frogment.activity.ActivityCallbacks;
import ch.grze.frogment.activity.StateAwareActivityCallbacks;
import ch.grze.frogment.frogment.FrogmentCallbacks;
import ch.grze.frogment.frogment.StateAwareFrogmentCallbacks;

public class Core {
    private final ActivityCallbacks activityCallbacks;
    private final FrogmentCallbacks frogmentCallbacks;
    private final StateAwareActivityCallbacks stateAwareActivityCallbacks;
    private final StateAwareFrogmentCallbacks stateAwareFrogmentCallbacks;

    private final Config config;

    public Core(Application application, Config config) {
        this.config = config;

        activityCallbacks = new ActivityCallbacks(this);
        stateAwareActivityCallbacks = new StateAwareActivityCallbacks(this);

        frogmentCallbacks = new FrogmentCallbacks(this);
        stateAwareFrogmentCallbacks = new StateAwareFrogmentCallbacks(this);

        application.registerActivityLifecycleCallbacks(getActivityCallbacks());
        application.registerActivityLifecycleCallbacks(getStateAwareActivityCallbacks());
    }

    public Config getConfig() {
        return config;
    }

    public ActivityCallbacks getActivityCallbacks() {
        return activityCallbacks;
    }

    public FrogmentCallbacks getFrogmentCallbacks() {
        return frogmentCallbacks;
    }

    public StateAwareActivityCallbacks getStateAwareActivityCallbacks() {
        return stateAwareActivityCallbacks;
    }

    public StateAwareFrogmentCallbacks getStateAwareFrogmentCallbacks() {
        return stateAwareFrogmentCallbacks;
    }
}
