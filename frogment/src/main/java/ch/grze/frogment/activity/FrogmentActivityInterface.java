package ch.grze.frogment.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;

import ch.grze.frogment.ActivityInterface;
import ch.grze.frogment.core.module.backstack.BackStackChangeListener;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogment.frogment.FrogmentInterface;

public interface FrogmentActivityInterface extends ActivityInterface, BackStackChangeListener {
    String FROGMENT_DATA = "frogment_data";

    FrogmentActivityComponent getFrogmentActivityComponent();
    void setFrogmentActivityComponent(FrogmentActivityComponent component);

    @IdRes
    int getFrogmentContainerId();
    FrogmentData getDefaultFrogmentData();

    @Override @CallSuper
    default void onFrogmentPushed(FrogmentInterface frogment) {
        onFrogmentConfigure(frogment);
    }

    @Override @CallSuper
    default void onFrogmentPopped(FrogmentInterface frogment) {
        onFrogmentConfigure(frogment);
    }

    @Override @CallSuper
    default void onBackStackEmpty() {
        getFrogmentActivityComponent().onBackStackEmpty();
    }

    @CallSuper
    default void switchFrogment(FrogmentData data) {
        getFrogmentActivityComponent().switchFrogment(data);
    }

    @CallSuper
    default void switchActivity(FrogmentActivityData data) {
        getFrogmentActivityComponent().switchActivity(data);
    }

    @CallSuper
    default void onFrogmentConfigure(FrogmentInterface frogment) {
        getFrogmentActivityComponent().onFrogmentConfigure(frogment);
    }
}
