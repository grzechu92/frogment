package ch.grze.frogmentexample.sample.commons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ch.grze.frogment.frogment.AbstractFrogment;
import ch.grze.frogment.frogment.FrogmentInterface;
import ch.grze.frogmentexample.R;

public class FragmentFirst extends AbstractFrogment implements FrogmentInterface {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
}
