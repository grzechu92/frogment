package ch.grze.frogment.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;

public abstract class StateAwareFrogmentActivity<T extends FrogmentActivityState> extends FrogmentActivity {
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

    final public T getState() {
        return state;
    }

    final public void setState(T state) {
        this.state = state;
        onStateValidation(state);
        onStateChanged(state);
    }

    public void onStateValidation(T state) {}
    public void onStateChanged(T state) {}

    abstract public T getDefaultState();
}
