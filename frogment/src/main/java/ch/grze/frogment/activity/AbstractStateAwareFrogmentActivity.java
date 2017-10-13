package ch.grze.frogment.activity;

import ch.grze.frogment.State;

//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
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
