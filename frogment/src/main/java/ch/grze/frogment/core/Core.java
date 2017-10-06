package ch.grze.frogment.core;

import android.app.Application;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import ch.grze.frogment.activity.ActivityCallbacks;
import ch.grze.frogment.core.callbacks.FragmentCallbacks;
import ch.grze.frogment.core.extension.AbstractExtension;
import ch.grze.frogment.core.module.parser.Parser;

public class Core {
    private final List<FragmentManager.FragmentLifecycleCallbacks> fragmentLifecycleCallbacks = new ArrayList<>();
    private final List<Application.ActivityLifecycleCallbacks> activityLifecycleCallbacks = new ArrayList<>();

    private final Parser parser = new Parser();
    private final Config config;

    public Core(Application application, Config config, List<AbstractExtension> extensions) {
        this.config = config;

        initializeCallbacks();
        initializeExtensions(extensions);

        for (Application.ActivityLifecycleCallbacks callback : getActivityLifecycleCallbacks()) {
            application.registerActivityLifecycleCallbacks(callback);
        }
    }

    public Config getConfig() {
        return config;
    }

    public Parser getParser() {
        return parser;
    }

    public List<Application.ActivityLifecycleCallbacks> getActivityLifecycleCallbacks() {
        return activityLifecycleCallbacks;
    }

    public List<FragmentManager.FragmentLifecycleCallbacks> getFragmentLifecycleCallbacks() {
        return fragmentLifecycleCallbacks;
    }

    private void initializeCallbacks() {
        activityLifecycleCallbacks.add(new ActivityCallbacks(this));
        fragmentLifecycleCallbacks.add(new FragmentCallbacks(this));
    }

    private void initializeExtensions(List<AbstractExtension> extensions) {
        for (AbstractExtension extension : extensions) {
            extension.initialize(this);

            activityLifecycleCallbacks.addAll(extension.getActivityLifecycleCallbacks());
            fragmentLifecycleCallbacks.addAll(extension.getFragmentLifecycleCallbacks());
        }
    }
}
