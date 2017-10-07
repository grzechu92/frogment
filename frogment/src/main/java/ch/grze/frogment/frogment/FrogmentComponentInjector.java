package ch.grze.frogment.frogment;

import android.support.v4.app.Fragment;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.component.AbstractFragmentComponentInjector;

public class FrogmentComponentInjector extends AbstractFragmentComponentInjector {
    @Override
    public void inject(Core core, Fragment fragment) {
        try {
            final FrogmentInterface frogment = getTypedFragment(fragment);

            if (frogment.getFrogmentComponent() == null) {
                final FrogmentComponent component = new FrogmentComponent(core, frogment);
                frogment.setFrogmentComponent(component);
            }
        } catch (ClassCastException ignored) {}

        try {
            final StateAwareFrogmentInterface frogment = getTypedFragment(fragment);

            if (frogment.getStateAwareFrogmentComponent() == null) {
                final StateAwareFrogmentComponent component = new StateAwareFrogmentComponent(core, frogment);
                frogment.setStateAwareFrogmentComponent(component);
            }
        } catch (ClassCastException ignored) {}
    }
}
