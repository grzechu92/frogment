package ch.grze.frogment.frogment;

import android.os.Bundle;

import ch.grze.frogment.StateAware;

public abstract class StateAwareFrogment<T extends FrogmentState> extends Frogment implements StateAware<T> {
    public static final String STATE = "state";

    protected T state;

    final public T getState() {
        return state;
    }

    final public void setState(T state) {
        this.state = state;

        onBeforeStateChange(state);
        onStateChange(state);
    }

    protected void reloadState(Bundle arguments, Bundle savedInstanceState) {
        final T state = getCore().getParser().getData(STATE, getDefaultState(), arguments, savedInstanceState);


        setState(state);
    }
}
