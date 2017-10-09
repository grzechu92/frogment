package ch.grze.frogmentmvp.activity;

import ch.grze.frogment.State;
import ch.grze.frogment.activity.StateAwareFrogmentActivityComponent;
import ch.grze.frogment.activity.StateAwareFrogmentActivityInterface;
import ch.grze.frogmentmvp.presenter.MvpPresenter;

public abstract class AbstractMvpStateAwareFrogmentActivity<P extends MvpPresenter, S extends State> extends AbstractMvpFrogmentActivity<P> implements StateAwareFrogmentActivityInterface<S> {
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
