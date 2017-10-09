package ch.grze.frogmentmvp;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.extension.AbstractExtension;
import ch.grze.frogmentmvp.view.ActivityComponentInjector;
import ch.grze.frogmentmvp.view.FragmentComponentInjector;

public final class MvpExtension extends AbstractExtension {
    @Override
    public void initialize(Core core) {
        super.initialize(core);

        addActivityComponentInjector(new ActivityComponentInjector());
        addFragmentComponentInjector(new FragmentComponentInjector());
    }
}
