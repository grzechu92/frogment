package ch.grze.frogmentmvp.fragment;

import ch.grze.frogment.State;
import ch.grze.frogment.frogment.StateAwareFrogmentComponent;
import ch.grze.frogment.frogment.StateAwareFrogmentInterface;
import ch.grze.frogmentmvp.presenter.MvpPresenter;

public abstract class AbstractMvpStateAwareFrogment<P extends MvpPresenter, S extends State> extends AbstractMvpFrogment implements StateAwareFrogmentInterface<S> {
    private StateAwareFrogmentComponent<S> stateAwareFrogmentComponent;

    @Override
    public StateAwareFrogmentComponent<S> getStateAwareFrogmentComponent() {
        return stateAwareFrogmentComponent;
    }

    @Override
    public void setStateAwareFrogmentComponent(StateAwareFrogmentComponent<S> component) {
        stateAwareFrogmentComponent = component;
    }
}
