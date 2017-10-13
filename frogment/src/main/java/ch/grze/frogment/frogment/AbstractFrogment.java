package ch.grze.frogment.frogment;

import android.support.v4.app.Fragment;

//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
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
