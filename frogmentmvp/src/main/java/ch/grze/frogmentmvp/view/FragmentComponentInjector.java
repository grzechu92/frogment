package ch.grze.frogmentmvp.view;

import android.support.v4.app.Fragment;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.component.AbstractFragmentComponentInjector;

public class FragmentComponentInjector extends AbstractFragmentComponentInjector {
    @Override
    public void inject(Core core, Fragment fragment) {
        try {
            final PresenterAwareMvpView mvpFragment = getTypedFragment(fragment);

            final MvpPresenterComponent component = new MvpPresenterComponent(mvpFragment);
            mvpFragment.setMvpPresenterComponent(component);
        } catch (ClassCastException ignored) {}
    }
}
