package ch.grze.frogment.core.backstack;

import ch.grze.frogment.frogment.FrogmentInterface;

public interface BackStackChangeListener {
    void onFrogmentPushed(FrogmentInterface frogment);
    void onFrogmentPopped(FrogmentInterface frogment);
    void onBackStackEmpty();
}
