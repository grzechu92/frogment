package ch.grze.frogment.core.extension;

import android.app.Application;
import android.support.annotation.CallSuper;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.component.AbstractActivityComponentInjector;
import ch.grze.frogment.core.component.AbstractFragmentComponentInjector;

public abstract class AbstractExtension {
    private final List<Application.ActivityLifecycleCallbacks> activityLifecycleCallbacks = new ArrayList<>();
    private final List<FragmentManager.FragmentLifecycleCallbacks> fragmentLifecycleCallbacks = new ArrayList<>();
    private final List<AbstractActivityComponentInjector> activityComponentInjectors = new ArrayList<>();
    private final List<AbstractFragmentComponentInjector> fragmentComponentInjectors = new ArrayList<>();
    protected Core core;

    @CallSuper
    public void initialize(Core core) {
        this.core = core;
    }

    final public List<Application.ActivityLifecycleCallbacks> getActivityLifecycleCallbacks() {
        return activityLifecycleCallbacks;
    }

    final public List<FragmentManager.FragmentLifecycleCallbacks> getFragmentLifecycleCallbacks() {
        return fragmentLifecycleCallbacks;
    }

    final public List<AbstractActivityComponentInjector> getActivityComponentInjectors() {
        return activityComponentInjectors;
    }

    final public List<AbstractFragmentComponentInjector> getFragmentComponentInjectors() {
        return fragmentComponentInjectors;
    }

    final protected void addActivityLifecycleCallback(Application.ActivityLifecycleCallbacks callback) {
        activityLifecycleCallbacks.add(callback);
    }

    final protected void addFragmentLifecycleCallback(FragmentManager.FragmentLifecycleCallbacks callback) {
        fragmentLifecycleCallbacks.add(callback);
    }

    final protected void addActivityComponentInjector(AbstractActivityComponentInjector injector) {
        activityComponentInjectors.add(injector);
    }

    final protected void addFragmentComponentInjector(AbstractFragmentComponentInjector injector) {
        fragmentComponentInjectors.add(injector);
    }
}
