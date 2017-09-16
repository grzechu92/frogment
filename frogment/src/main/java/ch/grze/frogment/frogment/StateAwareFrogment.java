package ch.grze.frogment.frogment;

import android.os.Bundle;

import ch.grze.frogment.StateAware;
import ch.grze.frogment.ViewStateAware;

public abstract class StateAwareFrogment<T extends FrogmentState> extends Frogment implements StateAware<T>, ViewStateAware {
    public static final String STATE = "state";

    protected boolean isViewReady = false;
    protected T state;

    @Override
    public void onViewReady() {
        isViewReady = true;
        onViewStateChange(state);
    }

    @Override
    public boolean isViewReady() {
        return isViewReady;
    }

    final public T getState() {
        return state;
    }

    final public void setState(T state) {
        this.state = state;

        onBeforeStateChange(state);
        onStateChange(state);

        if (shouldCallViewStateChange()) {
            onViewStateChange(state);
        }
    }

    protected void reloadState(Bundle arguments, Bundle savedInstanceState) {
        final T state = getCore().getParser().getData(STATE, getDefaultState(), arguments, savedInstanceState);

        setState(state);
    }

    private boolean shouldCallViewStateChange() {
        return isViewReady || !getCore().getConfig().isWaitForViewReadyWithStateChange();
    }
}
