package ch.grze.frogment.core;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import ch.grze.frogment.activity.ActivityCallbacks;
import ch.grze.frogment.activity.ActivityComponentInjector;
import ch.grze.frogment.core.callbacks.ActivityComponentInjectorCallbacks;
import ch.grze.frogment.core.callbacks.FragmentCallbacks;
import ch.grze.frogment.core.component.AbstractActivityComponentInjector;
import ch.grze.frogment.core.component.AbstractFragmentComponentInjector;
import ch.grze.frogment.core.extension.AbstractExtension;
import ch.grze.frogment.core.module.parser.Parser;

public class Core {
    private final List<FragmentManager.FragmentLifecycleCallbacks> fragmentLifecycleCallbacks = new ArrayList<>();
    private final List<Application.ActivityLifecycleCallbacks> activityLifecycleCallbacks = new ArrayList<>();
    private final List<AbstractActivityComponentInjector> activityComponentInjectors = new ArrayList<>();
    private final List<AbstractFragmentComponentInjector> fragmentComponentInjectors = new ArrayList<>();

    private final Parser parser = new Parser();
    private final Config config;

    public Core(Application application, Config config, List<AbstractExtension> extensions) {
        this.config = config;

        initializeCallbacks();
        initializeInjectors();
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

    public void injectComponents(Activity activity) {
        for (AbstractActivityComponentInjector injector : activityComponentInjectors) {
            injector.inject(this, activity);
        }
    }

    public void injectComponents(Fragment fragment) {
        for (AbstractFragmentComponentInjector injector : fragmentComponentInjectors) {
            injector.inject(this, fragment);
        }
    }

    private void initializeInjectors() {
        activityComponentInjectors.add(new ActivityComponentInjector());
    }

    private void initializeCallbacks() {
        activityLifecycleCallbacks.add(new ActivityComponentInjectorCallbacks(this));

        activityLifecycleCallbacks.add(new ActivityCallbacks(this));
        fragmentLifecycleCallbacks.add(new FragmentCallbacks(this));
    }

    private void initializeExtensions(List<AbstractExtension> extensions) {
        for (AbstractExtension extension : extensions) {
            extension.initialize(this);

            activityLifecycleCallbacks.addAll(extension.getActivityLifecycleCallbacks());
            fragmentLifecycleCallbacks.addAll(extension.getFragmentLifecycleCallbacks());
            activityComponentInjectors.addAll(extension.getActivityComponentInjectors());
            fragmentComponentInjectors.addAll(extension.getFragmentComponentInjectors());
        }
    }
}
