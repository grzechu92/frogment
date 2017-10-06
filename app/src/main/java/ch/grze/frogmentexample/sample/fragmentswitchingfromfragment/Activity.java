package ch.grze.frogmentexample.sample.fragmentswitchingfromfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ch.grze.frogment.activity.AbstractFrogmentActivity;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogmentexample.R;
import ch.grze.frogmentexample.sample.commons.FragmentFirstWithButton;

public class Activity extends AbstractFrogmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_with_container);
    }

    @Override
    public int getFrogmentContainerId() {
        return R.id.fragment_container;
    }

    @Override
    public FrogmentData getDefaultFrogmentData() {
        return FrogmentData.forClass(FragmentFirstWithButton.class);
    }
}
