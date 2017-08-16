package ch.grze.frogment.frogment;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class StateAwareFrogment<T extends FrogmentState> extends Frogment {
    public static final String STATE = "state";

    protected T state;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        state = getInitialFragmentState(getArguments(), savedInstanceState);

        onStateValidation(state);
        onStateChanged(state);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(STATE, state);
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

    protected T getInitialFragmentState(Bundle arguments, Bundle savedInstanceState) {
        T state;

        final T stateFromArguments = getStateFromBundle(arguments);
        final T stateFromSavedInstance = getStateFromBundle(savedInstanceState);

        state = (stateFromSavedInstance != null) ? stateFromSavedInstance : stateFromArguments;
        return state == null ? getDefaultState() : state;
    }

    protected T getStateFromBundle(Bundle bundle) {
        if (bundle != null && bundle.getParcelable(STATE) != null) {
            return bundle.getParcelable(STATE);
        }

        return null;
    }
}
