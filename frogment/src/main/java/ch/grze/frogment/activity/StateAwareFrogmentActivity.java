package ch.grze.frogment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;

import ch.grze.frogment.ActivityStateProvider;
import ch.grze.frogment.StateAware;
import ch.grze.frogment.frogment.Frogment;

public abstract class StateAwareFrogmentActivity<T extends FrogmentActivityState> extends FrogmentActivity implements StateAware<T> {
    public static final String STATE = "state";

    protected T state;

    public StateAwareFrogmentActivity(@IdRes int frogmentContainerId) {
        super(frogmentContainerId);
    }

    @Override
    protected void onFrogmentConfigure(Frogment frogment) {
        super.onFrogmentConfigure(frogment);

        if (frogment instanceof ActivityStateProvider) {
            final ActivityStateProvider<T> provider = (ActivityStateProvider<T>) frogment;

            setState(provider.getFrogmentActivityState());
        }
    }

    final public T getState() {
        return state;
    }

    final public void setState(T state) {
        this.state = state;

        onBeforeStateChange(state);
        onStateChange(state);
    }

    protected void reloadState(Intent intent, Bundle savedInstanceState) {
        final T state = getCore().getParser().getData(STATE, getDefaultState(), savedInstanceState, intent);

        setState(state);
    }
}
