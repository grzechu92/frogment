package ch.grze.frogment.backstack;

import ch.grze.frogment.frogment.Frogment;

public interface BackStackChangeListener {
    default void onFrogmentPushed(Frogment frogment) {}
    default void onFrogmentPopped(Frogment frogment) {}
    default void onBackStackEmpty() {}
}
