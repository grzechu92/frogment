package ch.grze.frogment.activity;

import ch.grze.frogment.State;

public abstract class AbstractStateAwareFrogmentActivity<S extends State> extends AbstractFrogmentActivity implements StateAwareFrogmentActivityInterface<S> {
    private StateAwareFrogmentActivityComponent<S> stateAwareFrogmentActivityComponent;

    @Override
    public StateAwareFrogmentActivityComponent<S> getStateAwareFrogmentActivityComponent() {
        return stateAwareFrogmentActivityComponent;
    }

    @Override
    public void setStateAwareFrogmentActivityComponent(StateAwareFrogmentActivityComponent<S> component) {
        stateAwareFrogmentActivityComponent = component;
    }
}
