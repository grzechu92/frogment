package ch.grze.frogment.frogment;

import android.support.v4.app.Fragment;

public abstract class AbstractFrogment extends Fragment implements FrogmentInterface {
    private FrogmentComponent frogmentComponent;

    @Override
    public FrogmentComponent getFrogmentComponent() {
        return frogmentComponent;
    }

    @Override
    public void setFrogmentComponent(FrogmentComponent component) {
        frogmentComponent = component;
    }
}
