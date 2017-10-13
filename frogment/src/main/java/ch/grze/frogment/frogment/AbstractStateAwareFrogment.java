package ch.grze.frogment.frogment;

import ch.grze.frogment.State;

//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
public abstract class AbstractStateAwareFrogment<S extends State> extends AbstractFrogment implements StateAwareFrogmentInterface<S> {
    private StateAwareFrogmentComponent stateAwareFrogmentComponent;

    @Override
    public StateAwareFrogmentComponent getStateAwareFrogmentComponent() {
        return stateAwareFrogmentComponent;
    }

    @Override
    public void setStateAwareFrogmentComponent(StateAwareFrogmentComponent component) {
        stateAwareFrogmentComponent = component;
    }
}
