package ch.grze.frogmentexample.mvpsample.mvpfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ch.grze.frogment.activity.AbstractFrogmentActivity;
import ch.grze.frogment.core.navigation.FrogmentData;
import ch.grze.frogmentexample.R;

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
        return FrogmentData.forClass(Fragment.class);
    }
}
