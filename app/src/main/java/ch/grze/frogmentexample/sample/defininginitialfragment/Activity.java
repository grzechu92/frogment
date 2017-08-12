package ch.grze.frogmentexample.sample.defininginitialfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ch.grze.frogment.activity.FrogmentActivity;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogmentexample.R;

public class Activity extends FrogmentActivity {
    public Activity() {
        super(R.id.fragment_container);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_container);

        super.onCreate(savedInstanceState);
    }

    @Override
    protected FrogmentData getDefaultFrogmentData() {
        return FrogmentData.forClass(Fragment1.class);
    }
}
