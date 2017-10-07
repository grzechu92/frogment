package ch.grze.frogment.activity;

import android.content.Intent;
import android.os.Bundle;

import ch.grze.frogment.ActivityStateProvider;
import ch.grze.frogment.State;
import ch.grze.frogment.StateAware;
import ch.grze.frogment.ViewStateAware;
import ch.grze.frogment.core.Core;
import ch.grze.frogment.frogment.FrogmentInterface;

final public class StateAwareFrogmentActivityComponent<S extends State> implements StateAware<S>, ViewStateAware {
    private final StateAwareFrogmentActivityInterface<S> stateAwareFrogmentActivity;
    private final Core core;

    private boolean isViewReady = false;
    private S state;

    public StateAwareFrogmentActivityComponent(Core core, StateAwareFrogmentActivityInterface<S> stateAwareFrogmentActivity) {
        this.core = core;
        this.stateAwareFrogmentActivity = stateAwareFrogmentActivity;
    }

    @Override
    public void onViewReady() {
        isViewReady = true;
        stateAwareFrogmentActivity.onViewStateChange(state);
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

        stateAwareFrogmentActivity.onBeforeStateChange(state);
        stateAwareFrogmentActivity.onStateChange(state);

        if (isViewReady) {
            stateAwareFrogmentActivity.onViewStateChange(state);
        }
    }

    @Override
    public S getDefaultState() {
        return stateAwareFrogmentActivity.getDefaultState();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        reloadState(stateAwareFrogmentActivity.getIntent(), savedInstanceState);
    }

    public void onActivityStarted() {
        onViewReady();
    }

    public void onActivitySaveInstanceState(Bundle outState) {
        stateAwareFrogmentActivity.onBeforeStateChange(state);
        outState.putParcelable(StateAwareFrogmentActivityInterface.STATE, state);
    }

    public void onFrogmentConfigure(FrogmentInterface frogment) {
        if (frogment instanceof ActivityStateProvider) {
            final ActivityStateProvider<S> provider = (ActivityStateProvider<S>) frogment;

            setState(provider.getFrogmentActivityState());
        }
    }

    private void reloadState(Intent intent, Bundle savedInstanceState) {
        final S state = core.getParser().getData(StateAwareFrogmentActivityInterface.STATE, getDefaultState(), savedInstanceState, intent);

        setState(state);
    }
}
