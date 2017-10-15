package ch.grze.frogment.frogment;

import android.support.annotation.CallSuper;

import ch.grze.frogment.FragmentInterface;
import ch.grze.frogment.SwitchAware;
import ch.grze.frogment.activity.FrogmentActivityData;
import ch.grze.frogment.activity.FrogmentActivityInterface;

//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
public interface FrogmentInterface extends FragmentInterface, SwitchAware {
    FrogmentComponent getFrogmentComponent();
    void setFrogmentComponent(FrogmentComponent component);

    @CallSuper
    default FrogmentData getData() {
        return getFrogmentComponent().getData();
    }

    @CallSuper
    default void setData(FrogmentData data) {
        getFrogmentComponent().setData(data);
    }

    @Override @CallSuper
    default void switchFrogment(FrogmentData data) {
        getFrogmentActivity().getFrogmentActivityComponent().switchFrogment(data);
    }

    @Override @CallSuper
    default void switchActivity(FrogmentActivityData data) {
        getFrogmentActivity().getFrogmentActivityComponent().switchActivity(data);
    }

    @CallSuper
    default FrogmentActivityInterface getFrogmentActivity() throws ClassCastException {
        return getFrogmentComponent().getFrogmentActivity();
    }

    @CallSuper
    default <T> T getTypedActivity() throws ClassCastException {
        return getFrogmentComponent().getTypedActivity();
    }
}
