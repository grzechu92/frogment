package ch.grze.frogment.core.callbacks;

import android.app.Activity;
import android.os.Bundle;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.CoreAware;

public class ActivityCallbacks extends AbstractActivityLifecycleCallbacks {
    private final Core core;

    public ActivityCallbacks(Core core) {
        this.core = core;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        super.onActivityCreated(activity, bundle);

        if (activity instanceof CoreAware) {
            final CoreAware coreAware = (CoreAware) activity;

            coreAware.setCore(core);
        }
    }
}
