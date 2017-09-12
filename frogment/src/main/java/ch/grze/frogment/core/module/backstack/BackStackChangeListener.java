package ch.grze.frogment.core.module.backstack;

import ch.grze.frogment.frogment.Frogment;

public interface BackStackChangeListener {
    void onFrogmentPushed(Frogment frogment);
    void onFrogmentPopped(Frogment frogment);
    void onBackStackEmpty();
}
