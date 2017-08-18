package ch.grze.frogment.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import ch.grze.frogment.ActivityStateProvider;
import ch.grze.frogment.StateAware;
import ch.grze.frogment.frogment.FrogmentData;

public abstract class StateAwareFrogmentActivity<T extends FrogmentActivityState> extends FrogmentActivity implements StateAware<T> {
    public static final String ACTIVITY_STATE = "activity_state";

    protected T state;

    public StateAwareFrogmentActivity(@IdRes int frogmentContainerId) {
        super(frogmentContainerId);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        state = getData(ACTIVITY_STATE, getDefaultState(), getIntent(), savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(ACTIVITY_STATE, state);
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
}
