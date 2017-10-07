package ch.grze.frogment.frogment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ch.grze.frogment.State;
import ch.grze.frogment.StateAware;
import ch.grze.frogment.ViewStateAware;
import ch.grze.frogment.core.Core;

public final class StateAwareFrogmentComponent<S extends State> implements StateAware<S>, ViewStateAware {
    private final StateAwareFrogmentInterface<S> stateAwareFrogment;
    private final Core core;

    private boolean isViewReady = false;
    private S state;

    public StateAwareFrogmentComponent(Core core, StateAwareFrogmentInterface<S> stateAwareFrogmentInterface) {
        this.core = core;
        this.stateAwareFrogment = stateAwareFrogmentInterface;
    }

    @Override
    public void onViewReady() {
        isViewReady = true;
        stateAwareFrogment.onViewStateChange(state);
    }

    @Override
    public boolean isViewReady() {
        return isViewReady;
    }

    @Override
    public S getState() {
        return state;
    }

    @Override
    public void setState(S state) {
        this.state = state;

        stateAwareFrogment.onBeforeStateChange(state);
        stateAwareFrogment.onStateChange(state);

        if (isViewReady) {
            stateAwareFrogment.onViewStateChange(state);
        }
    }

    @Override
    public S getDefaultState() {
        return stateAwareFrogment.getDefaultState();
    }

    public void onFragmentPreCreated(@Nullable Bundle savedInstanceState) {
        reloadState(stateAwareFrogment.getArguments(), savedInstanceState);
    }

    public void onFragmentActivityCreated(@Nullable Bundle savedInstanceState) {
        onViewReady();
    }

    public void onFragmentSaveInstanceState(Bundle outState) {
        stateAwareFrogment.onBeforeStateSave(state);
        outState.putParcelable(StateAwareFrogmentInterface.STATE, state);
    }

    private void reloadState(Bundle arguments, Bundle savedInstanceState) {
        final S state = core.getParser().getData(StateAwareFrogmentInterface.STATE, getDefaultState(), arguments, savedInstanceState);

        setState(state);
    }
}
