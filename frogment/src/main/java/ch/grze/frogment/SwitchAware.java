package ch.grze.frogment;

import ch.grze.frogment.activity.FrogmentActivityData;
import ch.grze.frogment.frogment.FrogmentData;

public interface SwitchAware {
    void switchFrogment(FrogmentData data);
    void switchActivity(FrogmentActivityData data);
}
