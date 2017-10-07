package ch.grze.frogment.core.callbacks;

import android.app.Activity;
import android.os.Bundle;

import ch.grze.frogment.core.Core;

public class ActivityComponentInjectorCallbacks extends AbstractActivityLifecycleCallbacks {
    public ActivityComponentInjectorCallbacks(Core core) {
        super(core);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        super.onActivityCreated(activity, bundle);

        core.injectComponents(activity);
    }
}
