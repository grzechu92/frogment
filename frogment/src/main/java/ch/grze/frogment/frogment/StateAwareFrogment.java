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

        T state = getDefaultState();

        if (savedInstanceState != null && savedInstanceState.getParcelable(STATE) != null) {
            try {
                state = (T) savedInstanceState.getParcelable(STATE);
            } catch (ClassCastException e) {}
        } else {
            if (getArguments() != null && getArguments().getParcelable(STATE) != null) {
                try {
                    state = (T) getArguments().getParcelable(STATE);
                } catch (ClassCastException e) {}
            }
        }

        onStateValidation(state);
        onStateChange(state);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(STATE, state);
    }

    public void onStateValidation(T state) {}
    public void onStateChange(T state) {}

    abstract public T getDefaultState();
}
