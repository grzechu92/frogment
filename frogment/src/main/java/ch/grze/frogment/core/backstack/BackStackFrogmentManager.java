package ch.grze.frogment.core.backstack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import ch.grze.frogment.frogment.FrogmentInterface;

public class BackStackFrogmentManager implements FragmentManager.OnBackStackChangedListener {
    private final BackStackChangeListener backStackChangeListener;
    private final FragmentManager fragmentManager;
    private int lastBackStackEntryCount = 0;

    public BackStackFrogmentManager(FragmentManager fragmentManager, BackStackChangeListener backStackChangeListener) {
        this.fragmentManager = fragmentManager;
        this.backStackChangeListener = backStackChangeListener;
        this.lastBackStackEntryCount = fragmentManager.getBackStackEntryCount();

        fragmentManager.addOnBackStackChangedListener(this);
    }

    @Override
    public void onBackStackChanged() {
        final int currentBackStackEntryCount = fragmentManager.getBackStackEntryCount();

        if (haveFragments()) {
            final FrogmentInterface frogment = getParentFragment();

            if (frogment != null) {
                if (wasPushed(currentBackStackEntryCount)) {
                    backStackChangeListener.onFrogmentPushed(frogment);
                }

                if (wasPopped(currentBackStackEntryCount)) {
                    backStackChangeListener.onFrogmentPopped(frogment);
                }
            }
        } else {
            backStackChangeListener.onBackStackEmpty();
        }

        lastBackStackEntryCount = currentBackStackEntryCount;
    }

    private boolean wasPushed(int backStackEntryCount) {
        return lastBackStackEntryCount < backStackEntryCount;
    }

    private boolean wasPopped(int backStackEntryCount) {
        return lastBackStackEntryCount > backStackEntryCount;
    }

    private boolean haveFragments() {
        final List<Fragment> fragmentList = fragmentManager.getFragments();

        return fragmentList != null && !fragmentList.isEmpty();
    }

    private FrogmentInterface getParentFragment() {
        final List<Fragment> fragmentList = fragmentManager.getFragments();

        return (FrogmentInterface) fragmentList.get(Math.max(0, fragmentList.size() - 2));
    }
}
