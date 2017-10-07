package ch.grze.frogment.frogment;

import android.support.v4.app.Fragment;

public abstract class AbstractFrogment extends Fragment implements FrogmentInterface {
    private FrogmentComponent component;

    @Override
    public FrogmentComponent getFrogmentComponent() {
        return component;
    }

    @Override
    public void setFrogmentComponent(FrogmentComponent component) {
        this.component = component;
    }
}
