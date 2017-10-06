package ch.grze.frogment.core.callbacks;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.CoreAware;

public class FragmentCallbacks extends AbstractFragmentLifecycleCallbacks {
    public FragmentCallbacks(Core core) {
        super(core);
    }

    @Override
    public void onFragmentAttached(FragmentManager fm, Fragment f, Context context) {
        super.onFragmentAttached(fm, f, context);

        try {
            final CoreAware coreAware = getTypedFragment(f);

            coreAware.setCore(core);
        } catch (ClassCastException ignored) {}
    }
}
