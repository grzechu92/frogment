package ch.grze.frogment.frogment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ch.grze.frogment.activity.FrogmentActivity;

public abstract class Frogment extends Fragment {
    private final int layoutResourceId;

    public Frogment(@LayoutRes int layoutResourceId) {
        this.layoutResourceId = layoutResourceId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(layoutResourceId, container, false);
    }

    protected FrogmentActivity getFrogmentActivity() {
        return (FrogmentActivity) getActivity();
    }
}
