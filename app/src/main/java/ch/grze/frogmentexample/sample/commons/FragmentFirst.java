package ch.grze.frogmentexample.sample.commons;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ch.grze.frogment.frogment.FrogmentComponent;
import ch.grze.frogment.frogment.FrogmentInterface;
import ch.grze.frogmentexample.R;

public class FragmentFirst extends Fragment implements FrogmentInterface {
    private FrogmentComponent component;

    @Override
    public FrogmentComponent getFrogmentComponent() {
        return component;
    }

    @Override
    public void setFrogmentComponent(FrogmentComponent component) {
        this.component = component;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
}
