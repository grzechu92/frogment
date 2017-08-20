package ch.grze.frogment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import ch.grze.frogment.ActivityStateProvider;
import ch.grze.frogment.StateAware;
import ch.grze.frogment.frogment.FrogmentData;

public abstract class StateAwareFrogmentActivity<T extends FrogmentActivityState> extends FrogmentActivity implements StateAware<T> {
    public static final String STATE = "state";

    protected T state;

    public StateAwareFrogmentActivity(@IdRes int frogmentContainerId) {
        super(frogmentContainerId);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        reloadState(getIntent(), savedInstanceState);

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        onBeforeStateSave(state);
        outState.putParcelable(STATE, state);
    }

    @Override
    public void switchFrogment(FrogmentData data) {
        super.switchFrogment(data);

        final Fragment fragment = getFragmentFrom(data);

        if (fragment instanceof ActivityStateProvider) {
            final ActivityStateProvider<T> provider = (ActivityStateProvider<T>) fragment;

            setState(provider.getFrogmentActivityState());
        }
    }

    final public T getState() {
        return state;
    }

    final public void setState(T state) {
        this.state = state;

        onStateValidation(state);
        onStateChanged(state);
    }

    protected void reloadState(Intent intent, Bundle savedInstanceState) {
        final T state = getData(STATE, getDefaultState(), intent, savedInstanceState);

        setState(state);
    }
}
