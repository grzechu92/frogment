package ch.grze.frogment.activity;

public abstract class AbstractStateAwareFrogmentActivity<S extends FrogmentActivityState> extends AbstractFrogmentActivity implements StateAwareFrogmentActivityInterface<S> {
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
