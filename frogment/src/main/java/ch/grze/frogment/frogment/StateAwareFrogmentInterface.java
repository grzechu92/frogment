package ch.grze.frogment.frogment;

import android.support.annotation.CallSuper;

import ch.grze.frogment.DefaultStateProvider;
import ch.grze.frogment.State;
import ch.grze.frogment.StateAware;
import ch.grze.frogment.StateCallbacksAware;

//todo remove DefaultStateProvider interface after refactor to Kotlin
//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
public interface StateAwareFrogmentInterface<S extends State> extends FrogmentInterface, StateAware<S>, StateCallbacksAware<S>, DefaultStateProvider<S> {
    String STATE = "state";

    StateAwareFrogmentComponent<S> getStateAwareFrogmentComponent();
    void setStateAwareFrogmentComponent(StateAwareFrogmentComponent<S> component);

    @Override @CallSuper
    default S getState() {
        return getStateAwareFrogmentComponent().getState();
    }

    @Override @CallSuper
    default void setState(S state) {
        getStateAwareFrogmentComponent().setState(state);
    }
}
