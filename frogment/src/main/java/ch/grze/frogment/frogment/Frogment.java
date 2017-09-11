package ch.grze.frogment.frogment;

import android.support.v4.app.Fragment;

import ch.grze.frogment.activity.FrogmentActivity;
import ch.grze.frogment.core.Core;

public abstract class Frogment extends Fragment {
    private FrogmentData data;
    private Core core;

    public final void setCore(Core core) {
        this.core = core;
    }

    public final FrogmentData getData() {
        return data;
    }

    public final void setData(FrogmentData data) {
        this.data = data;
    }

    protected FrogmentActivity getFrogmentActivity() {
        return (FrogmentActivity) getActivity();
    }

    protected <T> T getTypedActivity() {
        return (T) getFrogmentActivity();
    }
}
