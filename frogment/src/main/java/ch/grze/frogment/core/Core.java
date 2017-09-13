package ch.grze.frogment.core;

import android.app.Application;

import ch.grze.frogment.activity.ActivityCallbacks;
import ch.grze.frogment.activity.StateAwareActivityCallbacks;
import ch.grze.frogment.core.module.parser.Parser;
import ch.grze.frogment.frogment.FrogmentCallbacks;
import ch.grze.frogment.frogment.StateAwareFrogmentCallbacks;

public class Core {
    private final ActivityCallbacks activityCallbacks = new ActivityCallbacks(this);
    private final FrogmentCallbacks frogmentCallbacks = new FrogmentCallbacks(this);
    private final StateAwareActivityCallbacks stateAwareActivityCallbacks = new StateAwareActivityCallbacks(this);
    private final StateAwareFrogmentCallbacks stateAwareFrogmentCallbacks = new StateAwareFrogmentCallbacks(this);

    private final Parser parser = new Parser();
    private final Config config;

    public Core(Application application, Config config) {
        this.config = config;

        application.registerActivityLifecycleCallbacks(getActivityCallbacks());
        application.registerActivityLifecycleCallbacks(getStateAwareActivityCallbacks());
    }

    public Config getConfig() {
        return config;
    }

    public Parser getParser() {
        return parser;
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
