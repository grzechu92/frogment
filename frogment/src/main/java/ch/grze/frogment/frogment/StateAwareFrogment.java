package ch.grze.frogment.frogment;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class StateAwareFrogment<T extends FrogmentState> extends Frogment {
    public static final String STATE = "state";

    protected T state;

    public StateAwareFrogment(int layoutResourceId) {
        super(layoutResourceId);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        state = getInitialFragmentState(getArguments(), savedInstanceState);

        onStateValidation(state);
        onStateRestored(state);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(STATE, state);
    }

    public void onStateValidation(T state) {}
    public void onStateRestored(T state) {}

    abstract public T getDefaultState();

    protected T getInitialFragmentState(Bundle arguments, Bundle savedInstanceState) {
        final T stateFromArguments = getStateFromBundle(arguments);
        final T stateFromSavedInstance = getStateFromBundle(savedInstanceState);
        T state;

        if (savedInstanceState != null) {
            state = stateFromSavedInstance;
        } else {
            state = stateFromArguments;
        }

        return state == null ? getDefaultState() : state;
    }

    protected T getStateFromBundle(Bundle bundle) {
        if (bundle != null && bundle.getParcelable(STATE) != null) {
            return bundle.getParcelable(STATE);
        }

        return null;
    }
}
