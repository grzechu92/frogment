package ch.grze.frogment.frogment;

import android.support.annotation.CallSuper;

import ch.grze.frogment.FragmentInterface;
import ch.grze.frogment.activity.FrogmentActivityInterface;
import ch.grze.frogment.core.navigation.FrogmentData;
import ch.grze.frogment.core.navigation.Navigator;
import ch.grze.frogment.core.navigation.NavigatorAware;

//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
public interface FrogmentInterface extends FragmentInterface, NavigatorAware {
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

    @CallSuper
    default FrogmentActivityInterface getFrogmentActivity() throws ClassCastException {
        return getFrogmentComponent().getFrogmentActivity();
    }

    @CallSuper
    default <T> T getTypedActivity() throws ClassCastException {
        return getFrogmentComponent().getTypedActivity();
    }

    @Override
    default Navigator getNavigator() {
        return getFrogmentActivity().getNavigator();
    }
}
