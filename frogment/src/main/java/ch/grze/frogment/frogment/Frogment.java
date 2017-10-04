package ch.grze.frogment.frogment;

import android.support.v4.app.Fragment;

import ch.grze.frogment.activity.FrogmentActivity;
import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.CoreAware;

public abstract class Frogment extends Fragment implements CoreAware {
    private FrogmentData data;
    private Core core;

    @Override
    final public void setCore(Core core) {
        this.core = core;
    }

    @Override
    final public Core getCore() {
        return core;
    }

    final public FrogmentData getData() {
        return data;
    }

    final public void setData(FrogmentData data) {
        this.data = data;
    }

    protected FrogmentActivity getFrogmentActivity() {
        return (FrogmentActivity) getActivity();
    }

    protected <T> T getTypedActivity() {
        return (T) getFrogmentActivity();
    }
}
