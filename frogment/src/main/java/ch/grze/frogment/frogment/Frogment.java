package ch.grze.frogment.frogment;

import android.support.v4.app.Fragment;

import ch.grze.frogment.activity.FrogmentActivity;

public abstract class Frogment extends Fragment {
    protected FrogmentActivity getFrogmentActivity() {
        return (FrogmentActivity) getActivity();
    }

    protected <T> T getTypedActivity() {
        return (T) getFrogmentActivity();
    }
}
