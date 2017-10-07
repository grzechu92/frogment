package ch.grze.frogment.frogment;

import ch.grze.frogment.FragmentInterface;
import ch.grze.frogment.activity.FrogmentActivityInterface;

public interface FrogmentInterface extends FragmentInterface {
    FrogmentComponent getFrogmentComponent();
    void setFrogmentComponent(FrogmentComponent component);

    default FrogmentData getData() {
        return getFrogmentComponent().getData();
    }

    default void setData(FrogmentData data) {
        getFrogmentComponent().setData(data);
    }

    default FrogmentActivityInterface getFrogmentActivity() throws ClassCastException {
        return getFrogmentComponent().getFrogmentActivity();
    }

    default <T> T getTypedActivity() throws ClassCastException {
        return getFrogmentComponent().getTypedActivity();
    }
}
