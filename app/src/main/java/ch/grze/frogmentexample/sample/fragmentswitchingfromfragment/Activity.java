package ch.grze.frogmentexample.sample.fragmentswitchingfromfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import ch.grze.frogment.activity.FrogmentActivity;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogmentexample.R;
import ch.grze.frogmentexample.sample.commons.FragmentFirstWithButton;

public class Activity extends FrogmentActivity {
    public Activity() {
        super(R.id.fragment_container);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_container);

        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
    }

    @Override
    protected FrogmentData getDefaultFrogmentData() {
        return FrogmentData.forClass(FragmentFirstWithButton.class);
    }
}
