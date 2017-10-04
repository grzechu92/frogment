package ch.grze.frogment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import ch.grze.frogment.ActivityStateProvider;
import ch.grze.frogment.StateAware;
import ch.grze.frogment.ViewStateAware;
import ch.grze.frogment.frogment.Frogment;

public abstract class StateAwareFrogmentActivity<T extends FrogmentActivityState> extends FrogmentActivity implements StateAware<T>, ViewStateAware {
    public static final String STATE = "state";

    protected boolean isViewReady = false;
    protected T state;

    @Override @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        reloadState(getIntent(), savedInstanceState);
    }

    @Override @CallSuper
    protected void onStart() {
        super.onStart();

        onViewReady();
    }

    @Override @CallSuper
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        onBeforeStateSave(state);
        outState.putParcelable(StateAwareFrogmentActivity.STATE, state);
    }

    @Override @CallSuper
    protected void onFrogmentConfigure(Frogment frogment) {
        super.onFrogmentConfigure(frogment);

        if (frogment instanceof ActivityStateProvider) {
            final ActivityStateProvider<T> provider = (ActivityStateProvider<T>) frogment;

            setState(provider.getFrogmentActivityState());
        }
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
    protected void reloadState(Intent intent, Bundle savedInstanceState) {
        final T state = getCore().getParser().getData(STATE, getDefaultState(), savedInstanceState, intent);

        setState(state);
    }
}
