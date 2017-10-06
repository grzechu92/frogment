package ch.grze.frogment.frogment;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import ch.grze.frogment.StateAware;
import ch.grze.frogment.StateCallbacksAware;
import ch.grze.frogment.ViewStateAware;

public abstract class StateAwareFrogment<T extends FrogmentState> extends Frogment implements StateAware<T>, ViewStateAware, StateCallbacksAware<T> {
    public static final String STATE = "state";

    protected boolean isViewReady = false;
    protected T state;

    @Override @CallSuper
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        reloadState(getArguments(), savedInstanceState);
    }

    @Override @CallSuper
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        onViewReady();
    }

    @Override @CallSuper
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        onBeforeStateSave(state);
        outState.putParcelable(StateAwareFrogment.STATE, state);
    }

    @Override
    final public void onViewReady() {
        isViewReady = true;
        onViewStateChange(state);
    }

    @Override
    final public boolean isViewReady() {
        return isViewReady;
    }

    @Override
    final public T getState() {
        return state;
    }

    @Override
    final public void setState(T state) {
        this.state = state;

        onBeforeStateChange(state);
        onStateChange(state);

        if (isViewReady) {
            onViewStateChange(state);
        }
    }

    @CallSuper
    protected void reloadState(Bundle arguments, Bundle savedInstanceState) {
        final T state = getCore().getParser().getData(STATE, getDefaultState(), arguments, savedInstanceState);

        setState(state);
    }
}
