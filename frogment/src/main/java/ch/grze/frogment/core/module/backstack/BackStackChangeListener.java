package ch.grze.frogment.core.module.backstack;

import ch.grze.frogment.frogment.FrogmentInterface;

public interface BackStackChangeListener {
    void onFrogmentPushed(FrogmentInterface frogment);
    void onFrogmentPopped(FrogmentInterface frogment);
    void onBackStackEmpty();
}
