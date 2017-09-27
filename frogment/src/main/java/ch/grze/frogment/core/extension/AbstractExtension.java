package ch.grze.frogment.core.extension;

import android.app.Application;
import android.support.annotation.CallSuper;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import ch.grze.frogment.core.Core;

public abstract class AbstractExtension {
    protected final List<Application.ActivityLifecycleCallbacks> activityLifecycleCallbacks = new ArrayList<>();
    protected final List<FragmentManager.FragmentLifecycleCallbacks> fragmentLifecycleCallbacks = new ArrayList<>();
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

    protected void addActivityLifecycleCallback(Application.ActivityLifecycleCallbacks callback) {
        activityLifecycleCallbacks.add(callback);
    }

    protected void addFragmentLifecycleCallback(FragmentManager.FragmentLifecycleCallbacks callback) {
        fragmentLifecycleCallbacks.add(callback);
    }
}
