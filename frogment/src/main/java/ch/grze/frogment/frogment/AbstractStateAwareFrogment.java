package ch.grze.frogment.frogment;

import ch.grze.frogment.State;

public abstract class AbstractStateAwareFrogment<S extends State> extends AbstractFrogment implements StateAwareFrogmentInterface<S> {
    private StateAwareFrogmentComponent component;

    @Override
    public StateAwareFrogmentComponent getStateAwareFrogmentComponent() {
        return component;
    }

    @Override
    public void setStateAwareFrogmentComponent(StateAwareFrogmentComponent component) {
        this.component = component;
    }
}
