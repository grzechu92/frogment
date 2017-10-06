package ch.grze.frogment.activity;

import android.support.annotation.CallSuper;

import ch.grze.frogment.StateAware;
import ch.grze.frogment.StateCallbacksAware;
import ch.grze.frogment.frogment.Frogment;

public interface StateAwareFrogmentActivityInterface<S extends FrogmentActivityState> extends FrogmentActivityInterface, StateAware<S>, StateCallbacksAware<S> {
    String STATE = "state";

    StateAwareFrogmentActivityComponent<S> getStateAwareFrogmentActivityComponent();
    void setStateAwareFrogmentActivityComponent(StateAwareFrogmentActivityComponent<S> component);

    @Override @CallSuper
    default S getState() {
        return getStateAwareFrogmentActivityComponent().getState();
    }

    @Override @CallSuper
    default void setState(S state) {
        getStateAwareFrogmentActivityComponent().setState(state);
    }

    @Override @CallSuper
    default void onFrogmentConfigure(Frogment frogment) {
        FrogmentActivityInterface.super.onFrogmentConfigure(frogment);

        getStateAwareFrogmentActivityComponent().onFrogmentConfigure(frogment);
    }
}
