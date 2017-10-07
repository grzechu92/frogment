package ch.grze.frogment.frogment;

import ch.grze.frogment.activity.FrogmentActivityInterface;
import ch.grze.frogment.core.Core;

public final class FrogmentComponent {
    private final FrogmentInterface frogment;
    private final Core core;

    private FrogmentData data;

    public FrogmentComponent(Core core, FrogmentInterface frogment) {
        this.core = core;
        this.frogment = frogment;
    }

    public FrogmentData getData() {
        return data;
    }

    public void setData(FrogmentData data) {
        this.data = data;
    }

    public FrogmentActivityInterface getFrogmentActivity() {
        return (FrogmentActivityInterface) frogment.getActivity();
    }

    public <T> T getTypedActivity() {
        return (T) frogment.getActivity();
    }
}
